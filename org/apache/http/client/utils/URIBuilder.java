package org.apache.http.client.utils;

import cn.jiguang.net.HttpUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.http.message.BasicNameValuePair;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class URIBuilder {
    private String encodedAuthority;
    private String encodedFragment;
    private String encodedPath;
    private String encodedQuery;
    private String encodedSchemeSpecificPart;
    private String encodedUserInfo;
    private String fragment;
    private String host;
    private String path;
    private int port;
    private String query;
    private List<NameValuePair> queryParams;
    private String scheme;
    private String userInfo;

    public URIBuilder() {
        this.port = -1;
    }

    public URIBuilder(String str) throws URISyntaxException {
        digestURI(new URI(str));
    }

    public URIBuilder(URI uri) {
        digestURI(uri);
    }

    private List<NameValuePair> parseQuery(String str, Charset charset) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return URLEncodedUtils.parse(str, charset);
    }

    public URI build() throws URISyntaxException {
        return new URI(buildString());
    }

    private String buildString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.scheme != null) {
            stringBuilder.append(this.scheme).append(':');
        }
        if (this.encodedSchemeSpecificPart != null) {
            stringBuilder.append(this.encodedSchemeSpecificPart);
        } else {
            if (this.encodedAuthority != null) {
                stringBuilder.append("//").append(this.encodedAuthority);
            } else if (this.host != null) {
                stringBuilder.append("//");
                if (this.encodedUserInfo != null) {
                    stringBuilder.append(this.encodedUserInfo).append("@");
                } else if (this.userInfo != null) {
                    stringBuilder.append(encodeUserInfo(this.userInfo)).append("@");
                }
                if (InetAddressUtils.isIPv6Address(this.host)) {
                    stringBuilder.append("[").append(this.host).append("]");
                } else {
                    stringBuilder.append(this.host);
                }
                if (this.port >= 0) {
                    stringBuilder.append(":").append(this.port);
                }
            }
            if (this.encodedPath != null) {
                stringBuilder.append(normalizePath(this.encodedPath));
            } else if (this.path != null) {
                stringBuilder.append(encodePath(normalizePath(this.path)));
            }
            if (this.encodedQuery != null) {
                stringBuilder.append(HttpUtils.URL_AND_PARA_SEPARATOR).append(this.encodedQuery);
            } else if (this.queryParams != null) {
                stringBuilder.append(HttpUtils.URL_AND_PARA_SEPARATOR).append(encodeUrlForm(this.queryParams));
            } else if (this.query != null) {
                stringBuilder.append(HttpUtils.URL_AND_PARA_SEPARATOR).append(encodeUric(this.query));
            }
        }
        if (this.encodedFragment != null) {
            stringBuilder.append("#").append(this.encodedFragment);
        } else if (this.fragment != null) {
            stringBuilder.append("#").append(encodeUric(this.fragment));
        }
        return stringBuilder.toString();
    }

    private void digestURI(URI uri) {
        this.scheme = uri.getScheme();
        this.encodedSchemeSpecificPart = uri.getRawSchemeSpecificPart();
        this.encodedAuthority = uri.getRawAuthority();
        this.host = uri.getHost();
        this.port = uri.getPort();
        this.encodedUserInfo = uri.getRawUserInfo();
        this.userInfo = uri.getUserInfo();
        this.encodedPath = uri.getRawPath();
        this.path = uri.getPath();
        this.encodedQuery = uri.getRawQuery();
        this.queryParams = parseQuery(uri.getRawQuery(), Consts.UTF_8);
        this.encodedFragment = uri.getRawFragment();
        this.fragment = uri.getFragment();
    }

    private String encodeUserInfo(String str) {
        return URLEncodedUtils.encUserInfo(str, Consts.UTF_8);
    }

    private String encodePath(String str) {
        return URLEncodedUtils.encPath(str, Consts.UTF_8);
    }

    private String encodeUrlForm(List<NameValuePair> list) {
        return URLEncodedUtils.format((Iterable) list, Consts.UTF_8);
    }

    private String encodeUric(String str) {
        return URLEncodedUtils.encUric(str, Consts.UTF_8);
    }

    public URIBuilder setScheme(String str) {
        this.scheme = str;
        return this;
    }

    public URIBuilder setUserInfo(String str) {
        this.userInfo = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        this.encodedUserInfo = null;
        return this;
    }

    public URIBuilder setUserInfo(String str, String str2) {
        return setUserInfo(str + ':' + str2);
    }

    public URIBuilder setHost(String str) {
        this.host = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setPort(int i) {
        if (i < 0) {
            i = -1;
        }
        this.port = i;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setPath(String str) {
        this.path = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedPath = null;
        return this;
    }

    public URIBuilder removeQuery() {
        this.queryParams = null;
        this.query = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    @Deprecated
    public URIBuilder setQuery(String str) {
        this.queryParams = parseQuery(str, Consts.UTF_8);
        this.query = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setParameters(List<NameValuePair> list) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        } else {
            this.queryParams.clear();
        }
        this.queryParams.addAll(list);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder addParameters(List<NameValuePair> list) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        this.queryParams.addAll(list);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setParameters(NameValuePair... nameValuePairArr) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        } else {
            this.queryParams.clear();
        }
        for (Object add : nameValuePairArr) {
            this.queryParams.add(add);
        }
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder addParameter(String str, String str2) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        this.queryParams.add(new BasicNameValuePair(str, str2));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setParameter(String str, String str2) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        if (!this.queryParams.isEmpty()) {
            Iterator it = this.queryParams.iterator();
            while (it.hasNext()) {
                if (((NameValuePair) it.next()).getName().equals(str)) {
                    it.remove();
                }
            }
        }
        this.queryParams.add(new BasicNameValuePair(str, str2));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder clearParameters() {
        this.queryParams = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setCustomQuery(String str) {
        this.query = str;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.queryParams = null;
        return this;
    }

    public URIBuilder setFragment(String str) {
        this.fragment = str;
        this.encodedFragment = null;
        return this;
    }

    public boolean isAbsolute() {
        return this.scheme != null;
    }

    public boolean isOpaque() {
        return this.path == null;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getPath() {
        return this.path;
    }

    public List<NameValuePair> getQueryParams() {
        if (this.queryParams != null) {
            return new ArrayList(this.queryParams);
        }
        return new ArrayList();
    }

    public String getFragment() {
        return this.fragment;
    }

    public String toString() {
        return buildString();
    }

    private static String normalizePath(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '/') {
            i++;
        }
        if (i > 1) {
            return str.substring(i - 1);
        }
        return str;
    }
}
