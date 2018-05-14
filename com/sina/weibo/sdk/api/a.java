package com.sina.weibo.sdk.api;

import android.os.Bundle;

/* compiled from: TbsSdkJava */
public final class a {
    public TextObject a;
    public ImageObject b;
    public BaseMediaObject c;

    public a a(Bundle bundle) {
        this.a = (TextObject) bundle.getParcelable("_weibo_message_text");
        if (this.a != null) {
            this.a.a(bundle.getString("_weibo_message_text_extra"));
        }
        this.b = (ImageObject) bundle.getParcelable("_weibo_message_image");
        if (this.b != null) {
            this.b.a(bundle.getString("_weibo_message_image_extra"));
        }
        this.c = (BaseMediaObject) bundle.getParcelable("_weibo_message_media");
        if (this.c != null) {
            this.c.a(bundle.getString("_weibo_message_media_extra"));
        }
        return this;
    }
}
