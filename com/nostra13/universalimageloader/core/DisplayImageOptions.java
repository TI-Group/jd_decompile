package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

/* compiled from: TbsSdkJava */
public final class DisplayImageOptions {
    private final boolean cacheInMemory;
    private final boolean cacheOnDisk;
    private final boolean considerExifParams;
    private final Options decodingOptions;
    private final int delayBeforeLoading;
    private final BitmapDisplayer displayer;
    private final Object extraForDownloader;
    private final Handler handler;
    private final Drawable imageForEmptyUri;
    private final Drawable imageOnFail;
    private final Drawable imageOnLoading;
    private final int imageResForEmptyUri;
    private final int imageResOnFail;
    private final int imageResOnLoading;
    private final ImageScaleType imageScaleType;
    private final boolean isSyncLoading;
    private final BitmapProcessor postProcessor;
    private final BitmapProcessor preProcessor;
    private final boolean resetViewBeforeLoading;

    /* compiled from: TbsSdkJava */
    public static class Builder {
        private boolean cacheInMemory = false;
        private boolean cacheOnDisk = false;
        private boolean considerExifParams = false;
        private Options decodingOptions = new Options();
        private int delayBeforeLoading = 0;
        private BitmapDisplayer displayer = DefaultConfigurationFactory.createBitmapDisplayer();
        private Object extraForDownloader = null;
        private Handler handler = null;
        private Drawable imageForEmptyUri = null;
        private Drawable imageOnFail = null;
        private Drawable imageOnLoading = null;
        private int imageResForEmptyUri = 0;
        private int imageResOnFail = 0;
        private int imageResOnLoading = 0;
        private ImageScaleType imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        private boolean isSyncLoading = false;
        private BitmapProcessor postProcessor = null;
        private BitmapProcessor preProcessor = null;
        private boolean resetViewBeforeLoading = false;

        @Deprecated
        public Builder showStubImage(int i) {
            this.imageResOnLoading = i;
            return this;
        }

        public Builder showImageOnLoading(int i) {
            this.imageResOnLoading = i;
            return this;
        }

        public Builder showImageOnLoading(Drawable drawable) {
            this.imageOnLoading = drawable;
            return this;
        }

        public Builder showImageForEmptyUri(int i) {
            this.imageResForEmptyUri = i;
            return this;
        }

        public Builder showImageForEmptyUri(Drawable drawable) {
            this.imageForEmptyUri = drawable;
            return this;
        }

        public Builder showImageOnFail(int i) {
            this.imageResOnFail = i;
            return this;
        }

        public Builder showImageOnFail(Drawable drawable) {
            this.imageOnFail = drawable;
            return this;
        }

        public Builder resetViewBeforeLoading() {
            this.resetViewBeforeLoading = true;
            return this;
        }

        public Builder resetViewBeforeLoading(boolean z) {
            this.resetViewBeforeLoading = z;
            return this;
        }

        @Deprecated
        public Builder cacheInMemory() {
            this.cacheInMemory = true;
            return this;
        }

        public Builder cacheInMemory(boolean z) {
            this.cacheInMemory = z;
            return this;
        }

        @Deprecated
        public Builder cacheOnDisc() {
            return cacheOnDisk(true);
        }

        @Deprecated
        public Builder cacheOnDisc(boolean z) {
            return cacheOnDisk(z);
        }

        public Builder cacheOnDisk(boolean z) {
            this.cacheOnDisk = z;
            return this;
        }

        public Builder imageScaleType(ImageScaleType imageScaleType) {
            this.imageScaleType = imageScaleType;
            return this;
        }

        public Builder bitmapConfig(Config config) {
            if (config == null) {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            this.decodingOptions.inPreferredConfig = config;
            return this;
        }

        public Builder decodingOptions(Options options) {
            if (options == null) {
                throw new IllegalArgumentException("decodingOptions can't be null");
            }
            this.decodingOptions = options;
            return this;
        }

        public Builder delayBeforeLoading(int i) {
            this.delayBeforeLoading = i;
            return this;
        }

        public Builder extraForDownloader(Object obj) {
            this.extraForDownloader = obj;
            return this;
        }

        public Builder considerExifParams(boolean z) {
            this.considerExifParams = z;
            return this;
        }

        public Builder preProcessor(BitmapProcessor bitmapProcessor) {
            this.preProcessor = bitmapProcessor;
            return this;
        }

        public Builder postProcessor(BitmapProcessor bitmapProcessor) {
            this.postProcessor = bitmapProcessor;
            return this;
        }

        public Builder displayer(BitmapDisplayer bitmapDisplayer) {
            if (bitmapDisplayer == null) {
                throw new IllegalArgumentException("displayer can't be null");
            }
            this.displayer = bitmapDisplayer;
            return this;
        }

        Builder syncLoading(boolean z) {
            this.isSyncLoading = z;
            return this;
        }

        public Builder handler(Handler handler) {
            this.handler = handler;
            return this;
        }

        public Builder cloneFrom(DisplayImageOptions displayImageOptions) {
            this.imageResOnLoading = displayImageOptions.imageResOnLoading;
            this.imageResForEmptyUri = displayImageOptions.imageResForEmptyUri;
            this.imageResOnFail = displayImageOptions.imageResOnFail;
            this.imageOnLoading = displayImageOptions.imageOnLoading;
            this.imageForEmptyUri = displayImageOptions.imageForEmptyUri;
            this.imageOnFail = displayImageOptions.imageOnFail;
            this.resetViewBeforeLoading = displayImageOptions.resetViewBeforeLoading;
            this.cacheInMemory = displayImageOptions.cacheInMemory;
            this.cacheOnDisk = displayImageOptions.cacheOnDisk;
            this.imageScaleType = displayImageOptions.imageScaleType;
            this.decodingOptions = displayImageOptions.decodingOptions;
            this.delayBeforeLoading = displayImageOptions.delayBeforeLoading;
            this.considerExifParams = displayImageOptions.considerExifParams;
            this.extraForDownloader = displayImageOptions.extraForDownloader;
            this.preProcessor = displayImageOptions.preProcessor;
            this.postProcessor = displayImageOptions.postProcessor;
            this.displayer = displayImageOptions.displayer;
            this.handler = displayImageOptions.handler;
            this.isSyncLoading = displayImageOptions.isSyncLoading;
            return this;
        }

        public DisplayImageOptions build() {
            return new DisplayImageOptions();
        }
    }

    private DisplayImageOptions(Builder builder) {
        this.imageResOnLoading = builder.imageResOnLoading;
        this.imageResForEmptyUri = builder.imageResForEmptyUri;
        this.imageResOnFail = builder.imageResOnFail;
        this.imageOnLoading = builder.imageOnLoading;
        this.imageForEmptyUri = builder.imageForEmptyUri;
        this.imageOnFail = builder.imageOnFail;
        this.resetViewBeforeLoading = builder.resetViewBeforeLoading;
        this.cacheInMemory = builder.cacheInMemory;
        this.cacheOnDisk = builder.cacheOnDisk;
        this.imageScaleType = builder.imageScaleType;
        this.decodingOptions = builder.decodingOptions;
        this.delayBeforeLoading = builder.delayBeforeLoading;
        this.considerExifParams = builder.considerExifParams;
        this.extraForDownloader = builder.extraForDownloader;
        this.preProcessor = builder.preProcessor;
        this.postProcessor = builder.postProcessor;
        this.displayer = builder.displayer;
        this.handler = builder.handler;
        this.isSyncLoading = builder.isSyncLoading;
    }

    public boolean shouldShowImageOnLoading() {
        return (this.imageOnLoading == null && this.imageResOnLoading == 0) ? false : true;
    }

    public boolean shouldShowImageForEmptyUri() {
        return (this.imageForEmptyUri == null && this.imageResForEmptyUri == 0) ? false : true;
    }

    public boolean shouldShowImageOnFail() {
        return (this.imageOnFail == null && this.imageResOnFail == 0) ? false : true;
    }

    public boolean shouldPreProcess() {
        return this.preProcessor != null;
    }

    public boolean shouldPostProcess() {
        return this.postProcessor != null;
    }

    public boolean shouldDelayBeforeLoading() {
        return this.delayBeforeLoading > 0;
    }

    public Drawable getImageOnLoading(Resources resources) {
        return this.imageResOnLoading != 0 ? resources.getDrawable(this.imageResOnLoading) : this.imageOnLoading;
    }

    public Drawable getImageForEmptyUri(Resources resources) {
        return this.imageResForEmptyUri != 0 ? resources.getDrawable(this.imageResForEmptyUri) : this.imageForEmptyUri;
    }

    public Drawable getImageOnFail(Resources resources) {
        return this.imageResOnFail != 0 ? resources.getDrawable(this.imageResOnFail) : this.imageOnFail;
    }

    public boolean isResetViewBeforeLoading() {
        return this.resetViewBeforeLoading;
    }

    public boolean isCacheInMemory() {
        return this.cacheInMemory;
    }

    public boolean isCacheOnDisk() {
        return this.cacheOnDisk;
    }

    public ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    public Options getDecodingOptions() {
        return this.decodingOptions;
    }

    public int getDelayBeforeLoading() {
        return this.delayBeforeLoading;
    }

    public boolean isConsiderExifParams() {
        return this.considerExifParams;
    }

    public Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    public BitmapProcessor getPreProcessor() {
        return this.preProcessor;
    }

    public BitmapProcessor getPostProcessor() {
        return this.postProcessor;
    }

    public BitmapDisplayer getDisplayer() {
        return this.displayer;
    }

    public Handler getHandler() {
        return this.handler;
    }

    boolean isSyncLoading() {
        return this.isSyncLoading;
    }

    public static DisplayImageOptions createSimple() {
        return new Builder().build();
    }
}
