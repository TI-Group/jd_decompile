package okhttp3.internal.framed;

import b.c;
import b.e;
import b.f;
import b.m;
import b.s;
import cn.jiguang.net.HttpUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
import org.apache.http.cookie.ClientCookie;

/* compiled from: TbsSdkJava */
final class Hpack {
    private static final Map<f, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final Header[] STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, HttpUtils.PATHS_SEPARATOR), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, HttpHost.DEFAULT_SCHEME_NAME), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header(ClientCookie.EXPIRES_ATTR, ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};

    /* compiled from: TbsSdkJava */
    static final class Reader {
        Header[] dynamicTable = new Header[8];
        int dynamicTableByteCount = 0;
        int headerCount = 0;
        private final List<Header> headerList = new ArrayList();
        private int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex = (this.dynamicTable.length - 1);
        private final e source;

        Reader(int i, s sVar) {
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i;
            this.source = m.a(sVar);
        }

        int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        void headerTableSizeSetting(int i) {
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i;
            adjustDynamicTableByteCount();
        }

        private void adjustDynamicTableByteCount() {
            if (this.maxDynamicTableByteCount >= this.dynamicTableByteCount) {
                return;
            }
            if (this.maxDynamicTableByteCount == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(this.dynamicTableByteCount - this.maxDynamicTableByteCount);
            }
        }

        private void clearDynamicTable() {
            this.headerList.clear();
            Arrays.fill(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                for (int length = this.dynamicTable.length - 1; length >= this.nextHeaderIndex && i > 0; length--) {
                    i -= this.dynamicTable[length].hpackSize;
                    this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                    this.headerCount--;
                    i2++;
                }
                System.arraycopy(this.dynamicTable, this.nextHeaderIndex + 1, this.dynamicTable, (this.nextHeaderIndex + 1) + i2, this.headerCount);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        void readHeaders() throws IOException {
            while (!this.source.e()) {
                int h = this.source.h() & 255;
                if (h == 128) {
                    throw new IOException("index == 0");
                } else if ((h & 128) == 128) {
                    readIndexedHeader(readInt(h, 127) - 1);
                } else if (h == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((h & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(h, 63) - 1);
                } else if ((h & 32) == 32) {
                    this.maxDynamicTableByteCount = readInt(h, 31);
                    if (this.maxDynamicTableByteCount < 0 || this.maxDynamicTableByteCount > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (h == 16 || h == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(h, 15) - 1);
                }
            }
        }

        public List<Header> getAndResetHeaderList() {
            List arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        private void readIndexedHeader(int i) throws IOException {
            if (isStaticHeader(i)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex < 0 || dynamicTableIndex > this.dynamicTable.length - 1) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.headerList.add(this.dynamicTable[dynamicTableIndex]);
        }

        private int dynamicTableIndex(int i) {
            return (this.nextHeaderIndex + 1) + i;
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i) throws IOException {
            this.headerList.add(new Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private f getName(int i) {
            if (isStaticHeader(i)) {
                return Hpack.STATIC_HEADER_TABLE[i].name;
            }
            return this.dynamicTable[dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length)].name;
        }

        private boolean isStaticHeader(int i) {
            return i >= 0 && i <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private void insertIntoDynamicTable(int i, Header header) {
            this.headerList.add(header);
            int i2 = header.hpackSize;
            if (i != -1) {
                i2 -= this.dynamicTable[dynamicTableIndex(i)].hpackSize;
            }
            if (i2 > this.maxDynamicTableByteCount) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i2) - this.maxDynamicTableByteCount);
            if (i == -1) {
                if (this.headerCount + 1 > this.dynamicTable.length) {
                    Object obj = new Header[(this.dynamicTable.length * 2)];
                    System.arraycopy(this.dynamicTable, 0, obj, this.dynamicTable.length, this.dynamicTable.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = obj;
                }
                evictToRecoverBytes = this.nextHeaderIndex;
                this.nextHeaderIndex = evictToRecoverBytes - 1;
                this.dynamicTable[evictToRecoverBytes] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[(evictToRecoverBytes + dynamicTableIndex(i)) + i] = header;
            }
            this.dynamicTableByteCount = i2 + this.dynamicTableByteCount;
        }

        private int readByte() throws IOException {
            return this.source.h() & 255;
        }

        int readInt(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            i3 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return (readByte << i3) + i2;
                }
                i2 += (readByte & 127) << i3;
                i3 += 7;
            }
        }

        f readByteString() throws IOException {
            int readByte = readByte();
            Object obj = (readByte & 128) == 128 ? 1 : null;
            readByte = readInt(readByte, 127);
            if (obj != null) {
                return f.of(Huffman.get().decode(this.source.g((long) readByte)));
            }
            return this.source.d((long) readByte);
        }
    }

    /* compiled from: TbsSdkJava */
    static final class Writer {
        private final c out;

        Writer(c cVar) {
            this.out = cVar;
        }

        void writeHeaders(List<Header> list) throws IOException {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                f toAsciiLowercase = ((Header) list.get(i)).name.toAsciiLowercase();
                Integer num = (Integer) Hpack.NAME_TO_FIRST_INDEX.get(toAsciiLowercase);
                if (num != null) {
                    writeInt(num.intValue() + 1, 15, 0);
                    writeByteString(((Header) list.get(i)).value);
                } else {
                    this.out.b(0);
                    writeByteString(toAsciiLowercase);
                    writeByteString(((Header) list.get(i)).value);
                }
            }
        }

        void writeInt(int i, int i2, int i3) throws IOException {
            if (i < i2) {
                this.out.b(i3 | i);
                return;
            }
            this.out.b(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.out.b((i4 & 127) | 128);
                i4 >>>= 7;
            }
            this.out.b(i4);
        }

        void writeByteString(f fVar) throws IOException {
            writeInt(fVar.size(), 127, 0);
            this.out.a(fVar);
        }
    }

    private Hpack() {
    }

    private static Map<f, Integer> nameToFirstIndex() {
        Map linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        for (int i = 0; i < STATIC_HEADER_TABLE.length; i++) {
            if (!linkedHashMap.containsKey(STATIC_HEADER_TABLE[i].name)) {
                linkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static f checkLowercase(f fVar) throws IOException {
        int i = 0;
        int size = fVar.size();
        while (i < size) {
            byte b = fVar.getByte(i);
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.utf8());
            }
        }
        return fVar;
    }
}
