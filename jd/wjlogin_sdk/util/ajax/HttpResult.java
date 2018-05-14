package jd.wjlogin_sdk.util.ajax;

/* compiled from: TbsSdkJava */
public class HttpResult {
    private String Error;
    private boolean IsError;
    private String Result;

    public void setError(String str) {
        this.Error = str;
    }

    public String getResult() {
        return this.Result;
    }

    public boolean isIsError() {
        return this.IsError;
    }

    public void setIsError(boolean z) {
        this.IsError = z;
    }

    public String getError() {
        return this.Error;
    }

    public void setResult(String str) {
        this.Result = str;
    }
}
