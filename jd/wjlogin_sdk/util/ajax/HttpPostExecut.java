package jd.wjlogin_sdk.util.ajax;

import android.content.Context;
import android.os.Build.VERSION;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.KeyStore;
import javax.net.ssl.SSLPeerUnverifiedException;
import jd.wjlogin_sdk.util.Config;
import jd.wjlogin_sdk.util.HttpConfig;
import jd.wjlogin_sdk.util.NetworkManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

/* compiled from: TbsSdkJava */
public class HttpPostExecut implements IHttpRequest {
    private Context context;
    private HttpResult httpResult;
    private String params;
    private int retryTimes = 1;
    private boolean retryWithHttp = false;
    private String url;
    private boolean useHttp = false;

    public HttpPostExecut(Context context, int i, boolean z, boolean z2) {
        this.context = context;
        this.retryTimes = i;
        this.retryWithHttp = z;
        this.useHttp = z2;
    }

    public void Execut() {
        HttpResponse httpResponse = null;
        int i;
        try {
            if (NetworkManager.isNetworkAvailable(this.context)) {
                HttpClient defaultHttpClient;
                HttpPost httpPost = new HttpPost(this.url);
                HttpEntity stringEntity = new StringEntity(this.params);
                stringEntity.setContentType(URLEncodedUtils.CONTENT_TYPE);
                httpPost.setEntity(stringEntity);
                httpPost.addHeader("User-Agent", "Android WJLoginSDK 1.4.1");
                if (VERSION.SDK_INT >= 11) {
                    defaultHttpClient = new DefaultHttpClient();
                } else {
                    KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                    instance.load(null, null);
                    SocketFactory mySSLSocketFactory = new MySSLSocketFactory(instance, this.context);
                    mySSLSocketFactory.setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
                    SchemeRegistry schemeRegistry = new SchemeRegistry();
                    schemeRegistry.register(new Scheme("https", mySSLSocketFactory, 443));
                    schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
                    HttpParams basicHttpParams = new BasicHttpParams();
                    HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
                    Object defaultHttpClient2 = new DefaultHttpClient(new SingleClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                }
                defaultHttpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, Integer.valueOf(HttpConfig.TIME_OUT));
                defaultHttpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, Integer.valueOf(HttpConfig.TIME_OUT));
                i = 0;
                HttpUriRequest httpUriRequest = httpPost;
                while (i < this.retryTimes) {
                    httpResponse = defaultHttpClient.execute(httpUriRequest);
                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
                        break;
                    }
                    if (this.retryTimes > 1 && this.retryWithHttp && this.url.startsWith(CommonUtil.URL_HEADER)) {
                        httpUriRequest = new HttpPost(this.url.replace(CommonUtil.URL_HEADER, "http://"));
                        httpUriRequest.setEntity(stringEntity);
                        httpUriRequest.addHeader("User-Agent", "Android WJLoginSDK 1.4.1");
                    }
                    i++;
                }
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    setHttpResult(EntityUtils.toString(httpResponse.getEntity()));
                    return;
                } else {
                    setHttpError(Config.ERR_CODE_RESPONSE_DATA_ERR, Config.ERR_MSG_RESPONSE_DATA_ERR);
                    return;
                }
            }
            setHttpError(-100, Config.ERR_MSG_LOCAL_NETWORK_FAILED);
        } catch (Exception e) {
            if (i == this.retryTimes - 1) {
                throw e;
            }
        } catch (ConnectTimeoutException e2) {
            setHttpError(Config.ERR_CODE_REQUEST_FAILED_OR_TIMEOUT, Config.ERR_MSG_REQUEST_FAILED_OR_TIMEOUT);
        } catch (NoHttpResponseException e3) {
            setHttpError(Config.ERR_CODE_REQUEST_FAILED_OR_TIMEOUT, Config.ERR_MSG_REQUEST_FAILED_OR_TIMEOUT);
        } catch (SocketException e4) {
            setHttpError(Config.ERR_CODE_REQUEST_FAILED_OR_TIMEOUT, Config.ERR_MSG_REQUEST_FAILED_OR_TIMEOUT);
        } catch (SSLPeerUnverifiedException e5) {
            e5.printStackTrace();
            setHttpError(-100, Config.ERR_MSG_LOCAL_NETWORK_FAILED);
        } catch (UnknownHostException e6) {
            setHttpError(-100, Config.ERR_MSG_LOCAL_NETWORK_FAILED);
        } catch (Exception e7) {
            e7.printStackTrace();
            setHttpError(-100, Config.ERR_MSG_LOCAL_NETWORK_FAILED);
        }
    }

    public void initRequest(String str, String str2) {
        if (this.useHttp) {
            str = str.replace(CommonUtil.URL_HEADER, "http://");
        }
        this.url = str;
        this.params = str2;
        this.httpResult = new HttpResult();
    }

    private void setHttpResult(String str) {
        this.httpResult.setResult(str);
        this.httpResult.setIsError(false);
    }

    private void setHttpError(int i, String str) {
        this.httpResult.setError(Config.makeErrMsg(i, str));
        this.httpResult.setIsError(true);
    }

    public HttpResult getHttpResult() {
        return this.httpResult;
    }
}
