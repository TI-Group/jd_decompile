package org.apache.commons.lang;

import android.support.v4.media.TransportMediator;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: TbsSdkJava */
class Entities {
    private static final String[][] APOS_ARRAY;
    private static final String[][] BASIC_ARRAY;
    public static final Entities HTML32 = new Entities();
    public static final Entities HTML40 = new Entities();
    static final String[][] HTML40_ARRAY;
    static final String[][] ISO8859_1_ARRAY;
    public static final Entities XML = new Entities();
    EntityMap map = new LookupEntityMap();

    /* compiled from: TbsSdkJava */
    interface EntityMap {
        void add(String str, int i);

        String name(int i);

        int value(String str);
    }

    /* compiled from: TbsSdkJava */
    static class ArrayEntityMap implements EntityMap {
        protected int growBy;
        protected String[] names;
        protected int size;
        protected int[] values;

        public ArrayEntityMap() {
            this.growBy = 100;
            this.size = 0;
            this.names = new String[this.growBy];
            this.values = new int[this.growBy];
        }

        public ArrayEntityMap(int i) {
            this.growBy = 100;
            this.size = 0;
            this.growBy = i;
            this.names = new String[i];
            this.values = new int[i];
        }

        public void add(String str, int i) {
            ensureCapacity(this.size + 1);
            this.names[this.size] = str;
            this.values[this.size] = i;
            this.size++;
        }

        protected void ensureCapacity(int i) {
            if (i > this.names.length) {
                int max = Math.max(i, this.size + this.growBy);
                Object obj = new String[max];
                System.arraycopy(this.names, 0, obj, 0, this.size);
                this.names = obj;
                Object obj2 = new int[max];
                System.arraycopy(this.values, 0, obj2, 0, this.size);
                this.values = obj2;
            }
        }

        public String name(int i) {
            for (int i2 = 0; i2 < this.size; i2++) {
                if (this.values[i2] == i) {
                    return this.names[i2];
                }
            }
            return null;
        }

        public int value(String str) {
            for (int i = 0; i < this.size; i++) {
                if (this.names[i].equals(str)) {
                    return this.values[i];
                }
            }
            return -1;
        }
    }

    /* compiled from: TbsSdkJava */
    static class BinaryEntityMap extends ArrayEntityMap {
        public BinaryEntityMap(int i) {
            super(i);
        }

        private int binarySearch(int i) {
            int i2 = 0;
            int i3 = this.size - 1;
            while (i2 <= i3) {
                int i4 = (i2 + i3) >> 1;
                int i5 = this.values[i4];
                if (i5 < i) {
                    i2 = i4 + 1;
                } else if (i5 <= i) {
                    return i4;
                } else {
                    i3 = i4 - 1;
                }
            }
            return -(i2 + 1);
        }

        public void add(String str, int i) {
            ensureCapacity(this.size + 1);
            int binarySearch = binarySearch(i);
            if (binarySearch <= 0) {
                binarySearch = -(binarySearch + 1);
                System.arraycopy(this.values, binarySearch, this.values, binarySearch + 1, this.size - binarySearch);
                this.values[binarySearch] = i;
                System.arraycopy(this.names, binarySearch, this.names, binarySearch + 1, this.size - binarySearch);
                this.names[binarySearch] = str;
                this.size++;
            }
        }

        public String name(int i) {
            int binarySearch = binarySearch(i);
            if (binarySearch < 0) {
                return null;
            }
            return this.names[binarySearch];
        }
    }

    /* compiled from: TbsSdkJava */
    static abstract class MapIntMap implements EntityMap {
        protected Map mapNameToValue = new TreeMap();
        protected Map mapValueToName = new TreeMap();

        MapIntMap() {
        }

        public void add(String str, int i) {
            this.mapNameToValue.put(str, new Integer(i));
            this.mapValueToName.put(new Integer(i), str);
        }

        public String name(int i) {
            return (String) this.mapValueToName.get(new Integer(i));
        }

        public int value(String str) {
            Object obj = this.mapNameToValue.get(str);
            if (obj == null) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }
    }

    /* compiled from: TbsSdkJava */
    static class HashEntityMap extends MapIntMap {
    }

    /* compiled from: TbsSdkJava */
    static class PrimitiveEntityMap implements EntityMap {
        private Map mapNameToValue = new HashMap();
        private IntHashMap mapValueToName = new IntHashMap();

        PrimitiveEntityMap() {
        }

        public void add(String str, int i) {
            this.mapNameToValue.put(str, new Integer(i));
            this.mapValueToName.put(i, str);
        }

        public String name(int i) {
            return (String) this.mapValueToName.get(i);
        }

        public int value(String str) {
            Object obj = this.mapNameToValue.get(str);
            if (obj == null) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }
    }

    /* compiled from: TbsSdkJava */
    static class LookupEntityMap extends PrimitiveEntityMap {
        private int LOOKUP_TABLE_SIZE = 256;
        private String[] lookupTable;

        LookupEntityMap() {
        }

        public String name(int i) {
            if (i < this.LOOKUP_TABLE_SIZE) {
                return lookupTable()[i];
            }
            return super.name(i);
        }

        private String[] lookupTable() {
            if (this.lookupTable == null) {
                createLookupTable();
            }
            return this.lookupTable;
        }

        private void createLookupTable() {
            this.lookupTable = new String[this.LOOKUP_TABLE_SIZE];
            for (int i = 0; i < this.LOOKUP_TABLE_SIZE; i++) {
                this.lookupTable[i] = super.name(i);
            }
        }
    }

    /* compiled from: TbsSdkJava */
    static class TreeEntityMap extends MapIntMap {
    }

    Entities() {
    }

    static {
        r0 = new String[4][];
        r0[0] = new String[]{"quot", "34"};
        r0[1] = new String[]{"amp", "38"};
        r0[2] = new String[]{"lt", "60"};
        r0[3] = new String[]{"gt", "62"};
        BASIC_ARRAY = r0;
        r0 = new String[1][];
        r0[0] = new String[]{"apos", "39"};
        APOS_ARRAY = r0;
        r0 = new String[96][];
        r0[0] = new String[]{"nbsp", "160"};
        r0[1] = new String[]{"iexcl", "161"};
        r0[2] = new String[]{"cent", "162"};
        r0[3] = new String[]{"pound", "163"};
        r0[4] = new String[]{"curren", "164"};
        r0[5] = new String[]{"yen", "165"};
        r0[6] = new String[]{"brvbar", "166"};
        r0[7] = new String[]{"sect", "167"};
        r0[8] = new String[]{"uml", "168"};
        r0[9] = new String[]{"copy", "169"};
        r0[10] = new String[]{"ordf", "170"};
        r0[11] = new String[]{"laquo", "171"};
        r0[12] = new String[]{"not", "172"};
        r0[13] = new String[]{"shy", "173"};
        r0[14] = new String[]{"reg", "174"};
        r0[15] = new String[]{"macr", "175"};
        r0[16] = new String[]{"deg", "176"};
        r0[17] = new String[]{"plusmn", "177"};
        r0[18] = new String[]{"sup2", "178"};
        r0[19] = new String[]{"sup3", "179"};
        r0[20] = new String[]{"acute", "180"};
        r0[21] = new String[]{"micro", "181"};
        r0[22] = new String[]{"para", "182"};
        r0[23] = new String[]{"middot", "183"};
        r0[24] = new String[]{"cedil", "184"};
        r0[25] = new String[]{"sup1", "185"};
        r0[26] = new String[]{"ordm", "186"};
        r0[27] = new String[]{"raquo", "187"};
        r0[28] = new String[]{"frac14", "188"};
        r0[29] = new String[]{"frac12", "189"};
        r0[30] = new String[]{"frac34", "190"};
        r0[31] = new String[]{"iquest", "191"};
        r0[32] = new String[]{"Agrave", "192"};
        r0[33] = new String[]{"Aacute", "193"};
        r0[34] = new String[]{"Acirc", "194"};
        r0[35] = new String[]{"Atilde", "195"};
        r0[36] = new String[]{"Auml", "196"};
        r0[37] = new String[]{"Aring", "197"};
        r0[38] = new String[]{"AElig", "198"};
        r0[39] = new String[]{"Ccedil", "199"};
        r0[40] = new String[]{"Egrave", "200"};
        r0[41] = new String[]{"Eacute", "201"};
        r0[42] = new String[]{"Ecirc", "202"};
        r0[43] = new String[]{"Euml", "203"};
        r0[44] = new String[]{"Igrave", "204"};
        r0[45] = new String[]{"Iacute", "205"};
        r0[46] = new String[]{"Icirc", "206"};
        r0[47] = new String[]{"Iuml", "207"};
        r0[48] = new String[]{"ETH", "208"};
        r0[49] = new String[]{"Ntilde", "209"};
        r0[50] = new String[]{"Ograve", "210"};
        r0[51] = new String[]{"Oacute", "211"};
        r0[52] = new String[]{"Ocirc", "212"};
        r0[53] = new String[]{"Otilde", "213"};
        r0[54] = new String[]{"Ouml", "214"};
        r0[55] = new String[]{"times", "215"};
        r0[56] = new String[]{"Oslash", "216"};
        r0[57] = new String[]{"Ugrave", "217"};
        r0[58] = new String[]{"Uacute", "218"};
        r0[59] = new String[]{"Ucirc", "219"};
        r0[60] = new String[]{"Uuml", "220"};
        r0[61] = new String[]{"Yacute", "221"};
        r0[62] = new String[]{"THORN", "222"};
        r0[63] = new String[]{"szlig", "223"};
        r0[64] = new String[]{"agrave", "224"};
        r0[65] = new String[]{"aacute", "225"};
        r0[66] = new String[]{"acirc", "226"};
        r0[67] = new String[]{"atilde", "227"};
        r0[68] = new String[]{"auml", "228"};
        r0[69] = new String[]{"aring", "229"};
        r0[70] = new String[]{"aelig", "230"};
        r0[71] = new String[]{"ccedil", "231"};
        r0[72] = new String[]{"egrave", "232"};
        r0[73] = new String[]{"eacute", "233"};
        r0[74] = new String[]{"ecirc", "234"};
        r0[75] = new String[]{"euml", "235"};
        r0[76] = new String[]{"igrave", "236"};
        r0[77] = new String[]{"iacute", "237"};
        r0[78] = new String[]{"icirc", "238"};
        r0[79] = new String[]{"iuml", "239"};
        r0[80] = new String[]{"eth", "240"};
        r0[81] = new String[]{"ntilde", "241"};
        r0[82] = new String[]{"ograve", "242"};
        r0[83] = new String[]{"oacute", "243"};
        r0[84] = new String[]{"ocirc", "244"};
        r0[85] = new String[]{"otilde", "245"};
        r0[86] = new String[]{"ouml", "246"};
        r0[87] = new String[]{"divide", "247"};
        r0[88] = new String[]{"oslash", "248"};
        r0[89] = new String[]{"ugrave", "249"};
        r0[90] = new String[]{"uacute", "250"};
        r0[91] = new String[]{"ucirc", "251"};
        r0[92] = new String[]{"uuml", "252"};
        r0[93] = new String[]{"yacute", "253"};
        r0[94] = new String[]{"thorn", "254"};
        r0[95] = new String[]{"yuml", "255"};
        ISO8859_1_ARRAY = r0;
        r0 = new String[151][];
        r0[0] = new String[]{"fnof", "402"};
        r0[1] = new String[]{"Alpha", "913"};
        r0[2] = new String[]{"Beta", "914"};
        r0[3] = new String[]{"Gamma", "915"};
        r0[4] = new String[]{"Delta", "916"};
        r0[5] = new String[]{"Epsilon", "917"};
        r0[6] = new String[]{"Zeta", "918"};
        r0[7] = new String[]{"Eta", "919"};
        r0[8] = new String[]{"Theta", "920"};
        r0[9] = new String[]{"Iota", "921"};
        r0[10] = new String[]{"Kappa", "922"};
        r0[11] = new String[]{"Lambda", "923"};
        r0[12] = new String[]{"Mu", "924"};
        r0[13] = new String[]{"Nu", "925"};
        r0[14] = new String[]{"Xi", "926"};
        r0[15] = new String[]{"Omicron", "927"};
        r0[16] = new String[]{"Pi", "928"};
        r0[17] = new String[]{"Rho", "929"};
        r0[18] = new String[]{"Sigma", "931"};
        r0[19] = new String[]{"Tau", "932"};
        r0[20] = new String[]{"Upsilon", "933"};
        r0[21] = new String[]{"Phi", "934"};
        r0[22] = new String[]{"Chi", "935"};
        r0[23] = new String[]{"Psi", "936"};
        r0[24] = new String[]{"Omega", "937"};
        r0[25] = new String[]{"alpha", "945"};
        r0[26] = new String[]{"beta", "946"};
        r0[27] = new String[]{"gamma", "947"};
        r0[28] = new String[]{"delta", "948"};
        r0[29] = new String[]{"epsilon", "949"};
        r0[30] = new String[]{"zeta", "950"};
        r0[31] = new String[]{"eta", "951"};
        r0[32] = new String[]{"theta", "952"};
        r0[33] = new String[]{"iota", "953"};
        r0[34] = new String[]{"kappa", "954"};
        r0[35] = new String[]{"lambda", "955"};
        r0[36] = new String[]{"mu", "956"};
        r0[37] = new String[]{"nu", "957"};
        r0[38] = new String[]{"xi", "958"};
        r0[39] = new String[]{"omicron", "959"};
        r0[40] = new String[]{"pi", "960"};
        r0[41] = new String[]{"rho", "961"};
        r0[42] = new String[]{"sigmaf", "962"};
        r0[43] = new String[]{"sigma", "963"};
        r0[44] = new String[]{"tau", "964"};
        r0[45] = new String[]{"upsilon", "965"};
        r0[46] = new String[]{"phi", "966"};
        r0[47] = new String[]{"chi", "967"};
        r0[48] = new String[]{"psi", "968"};
        r0[49] = new String[]{"omega", "969"};
        r0[50] = new String[]{"thetasym", "977"};
        r0[51] = new String[]{"upsih", "978"};
        r0[52] = new String[]{"piv", "982"};
        r0[53] = new String[]{"bull", "8226"};
        r0[54] = new String[]{"hellip", "8230"};
        r0[55] = new String[]{"prime", "8242"};
        r0[56] = new String[]{"Prime", "8243"};
        r0[57] = new String[]{"oline", "8254"};
        r0[58] = new String[]{"frasl", "8260"};
        r0[59] = new String[]{"weierp", "8472"};
        r0[60] = new String[]{"image", "8465"};
        r0[61] = new String[]{"real", "8476"};
        r0[62] = new String[]{"trade", "8482"};
        r0[63] = new String[]{"alefsym", "8501"};
        r0[64] = new String[]{"larr", "8592"};
        r0[65] = new String[]{"uarr", "8593"};
        r0[66] = new String[]{"rarr", "8594"};
        r0[67] = new String[]{"darr", "8595"};
        r0[68] = new String[]{"harr", "8596"};
        r0[69] = new String[]{"crarr", "8629"};
        r0[70] = new String[]{"lArr", "8656"};
        r0[71] = new String[]{"uArr", "8657"};
        r0[72] = new String[]{"rArr", "8658"};
        r0[73] = new String[]{"dArr", "8659"};
        r0[74] = new String[]{"hArr", "8660"};
        r0[75] = new String[]{"forall", "8704"};
        r0[76] = new String[]{"part", "8706"};
        r0[77] = new String[]{"exist", "8707"};
        r0[78] = new String[]{"empty", "8709"};
        r0[79] = new String[]{"nabla", "8711"};
        r0[80] = new String[]{"isin", "8712"};
        r0[81] = new String[]{"notin", "8713"};
        r0[82] = new String[]{"ni", "8715"};
        r0[83] = new String[]{"prod", "8719"};
        r0[84] = new String[]{"sum", "8721"};
        r0[85] = new String[]{"minus", "8722"};
        r0[86] = new String[]{"lowast", "8727"};
        r0[87] = new String[]{"radic", "8730"};
        r0[88] = new String[]{"prop", "8733"};
        r0[89] = new String[]{"infin", "8734"};
        r0[90] = new String[]{"ang", "8736"};
        r0[91] = new String[]{"and", "8743"};
        r0[92] = new String[]{"or", "8744"};
        r0[93] = new String[]{"cap", "8745"};
        r0[94] = new String[]{"cup", "8746"};
        r0[95] = new String[]{"int", "8747"};
        r0[96] = new String[]{"there4", "8756"};
        r0[97] = new String[]{"sim", "8764"};
        r0[98] = new String[]{"cong", "8773"};
        r0[99] = new String[]{"asymp", "8776"};
        r0[100] = new String[]{"ne", "8800"};
        r0[101] = new String[]{"equiv", "8801"};
        r0[102] = new String[]{"le", "8804"};
        r0[103] = new String[]{"ge", "8805"};
        r0[104] = new String[]{"sub", "8834"};
        r0[105] = new String[]{"sup", "8835"};
        r0[106] = new String[]{"sube", "8838"};
        r0[107] = new String[]{"supe", "8839"};
        r0[108] = new String[]{"oplus", "8853"};
        r0[109] = new String[]{"otimes", "8855"};
        r0[110] = new String[]{"perp", "8869"};
        r0[111] = new String[]{"sdot", "8901"};
        r0[112] = new String[]{"lceil", "8968"};
        r0[113] = new String[]{"rceil", "8969"};
        r0[114] = new String[]{"lfloor", "8970"};
        r0[115] = new String[]{"rfloor", "8971"};
        r0[116] = new String[]{"lang", "9001"};
        r0[117] = new String[]{"rang", "9002"};
        r0[118] = new String[]{"loz", "9674"};
        r0[119] = new String[]{"spades", "9824"};
        r0[ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR] = new String[]{"clubs", "9827"};
        r0[ErrorCode.THREAD_INIT_ERROR] = new String[]{"hearts", "9829"};
        r0[ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR] = new String[]{"diams", "9830"};
        r0[ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED] = new String[]{"OElig", "338"};
        r0[ErrorCode.DOWNLOAD_REDIRECT_EMPTY] = new String[]{"oelig", "339"};
        r0[ErrorCode.DOWNLOAD_THROWABLE] = new String[]{"Scaron", "352"};
        r0[TransportMediator.KEYCODE_MEDIA_PLAY] = new String[]{"scaron", "353"};
        r0[TransportMediator.KEYCODE_MEDIA_PAUSE] = new String[]{"Yuml", "376"};
        r0[128] = new String[]{"circ", "710"};
        r0[129] = new String[]{"tilde", "732"};
        r0[TransportMediator.KEYCODE_MEDIA_RECORD] = new String[]{"ensp", "8194"};
        r0[131] = new String[]{"emsp", "8195"};
        r0[132] = new String[]{"thinsp", "8201"};
        r0[133] = new String[]{"zwnj", "8204"};
        r0[134] = new String[]{"zwj", "8205"};
        r0[135] = new String[]{"lrm", "8206"};
        r0[136] = new String[]{"rlm", "8207"};
        r0[137] = new String[]{"ndash", "8211"};
        r0[138] = new String[]{"mdash", "8212"};
        r0[139] = new String[]{"lsquo", "8216"};
        r0[140] = new String[]{"rsquo", "8217"};
        r0[141] = new String[]{"sbquo", "8218"};
        r0[142] = new String[]{"ldquo", "8220"};
        r0[143] = new String[]{"rdquo", "8221"};
        r0[144] = new String[]{"bdquo", "8222"};
        r0[145] = new String[]{"dagger", "8224"};
        r0[146] = new String[]{"Dagger", "8225"};
        r0[147] = new String[]{"permil", "8240"};
        r0[148] = new String[]{"lsaquo", "8249"};
        r0[149] = new String[]{"rsaquo", "8250"};
        r0[150] = new String[]{"euro", "8364"};
        HTML40_ARRAY = r0;
        XML.addEntities(BASIC_ARRAY);
        XML.addEntities(APOS_ARRAY);
        HTML32.addEntities(BASIC_ARRAY);
        HTML32.addEntities(ISO8859_1_ARRAY);
        fillWithHtml40Entities(HTML40);
    }

    static void fillWithHtml40Entities(Entities entities) {
        entities.addEntities(BASIC_ARRAY);
        entities.addEntities(ISO8859_1_ARRAY);
        entities.addEntities(HTML40_ARRAY);
    }

    public void addEntities(String[][] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            addEntity(strArr[i][0], Integer.parseInt(strArr[i][1]));
        }
    }

    public void addEntity(String str, int i) {
        this.map.add(str, i);
    }

    public String entityName(int i) {
        return this.map.name(i);
    }

    public int entityValue(String str) {
        return this.map.value(str);
    }

    public String escape(String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length() * 2);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            String entityName = entityName(charAt);
            if (entityName != null) {
                stringBuffer.append('&');
                stringBuffer.append(entityName);
                stringBuffer.append(';');
            } else if (charAt > '') {
                stringBuffer.append("&#");
                stringBuffer.append(charAt);
                stringBuffer.append(';');
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public String unescape(String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '&') {
                int indexOf = str.indexOf(59, i + 1);
                if (indexOf == -1) {
                    stringBuffer.append(charAt);
                } else {
                    String substring = str.substring(i + 1, indexOf);
                    if (substring.charAt(0) == '#') {
                        i = Integer.parseInt(substring.substring(1));
                    } else {
                        i = entityValue(substring);
                    }
                    if (i == -1) {
                        stringBuffer.append('&');
                        stringBuffer.append(substring);
                        stringBuffer.append(';');
                    } else {
                        stringBuffer.append((char) i);
                    }
                    i = indexOf;
                }
            } else {
                stringBuffer.append(charAt);
            }
            i++;
        }
        return stringBuffer.toString();
    }
}
