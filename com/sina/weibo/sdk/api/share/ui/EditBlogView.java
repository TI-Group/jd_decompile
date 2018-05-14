package com.sina.weibo.sdk.api.share.ui;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class EditBlogView extends EditText {
    private Context a;
    private List<b> b;
    private a c;
    private boolean d = true;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a();
    }

    /* compiled from: TbsSdkJava */
    public interface b {
        void a(int i, int i2);
    }

    public EditBlogView(Context context) {
        super(context);
        a();
    }

    public EditBlogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public EditBlogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.a = getContext();
        this.b = new ArrayList();
    }

    public void setOnSelectionListener(b bVar) {
        this.b.add(bVar);
    }

    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (this.d && this.b != null && !this.b.isEmpty()) {
            for (b a : this.b) {
                a.a(i, i2);
            }
        }
    }

    public void setOnEnterListener(a aVar) {
        this.c = aVar;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 66 && this.c != null) {
            this.c.a();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public int a(int i) {
        if (i == -1) {
            return i;
        }
        Editable text = getText();
        if (i >= text.length()) {
            return i;
        }
        Object[] spans = text.getSpans(i, i, ImageSpan.class);
        if (spans == null || spans.length == 0 || i == text.getSpanStart(spans[0])) {
            return i;
        }
        return text.getSpanEnd(spans[0]);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new InputConnectionWrapper(this, super.onCreateInputConnection(editorInfo), false) {
            final /* synthetic */ EditBlogView a;

            public boolean commitText(CharSequence charSequence, int i) {
                Object editableText = this.a.getEditableText();
                String str = new String(editableText.toString());
                int selectionStart = Selection.getSelectionStart(editableText);
                int selectionEnd = Selection.getSelectionEnd(editableText);
                if (!(selectionStart == -1 || selectionEnd == -1)) {
                    int a = this.a.a(selectionStart);
                    int a2 = this.a.a(selectionEnd);
                    if (a <= a2) {
                        int i2 = a2;
                        a2 = a;
                        a = i2;
                    }
                    if (!(a2 == selectionStart && a == selectionEnd)) {
                        Selection.setSelection(editableText, a2, a);
                    }
                    if (a2 != a) {
                        this.a.getText().delete(a2, a);
                    }
                }
                return super.commitText(charSequence, i);
            }

            public boolean setComposingText(CharSequence charSequence, int i) {
                Object editableText = this.a.getEditableText();
                String str = new String(editableText.toString());
                int selectionStart = Selection.getSelectionStart(editableText);
                int selectionEnd = Selection.getSelectionEnd(editableText);
                if (!(selectionStart == -1 || selectionEnd == -1)) {
                    int a = this.a.a(selectionStart);
                    int a2 = this.a.a(selectionEnd);
                    if (a <= a2) {
                        int i2 = a2;
                        a2 = a;
                        a = i2;
                    }
                    if (!(a2 == selectionStart && a == selectionEnd)) {
                        Selection.setSelection(editableText, a2, a);
                    }
                    if (a2 != a) {
                        this.a.getText().delete(a2, a);
                    }
                }
                return super.setComposingText(charSequence, i);
            }
        };
    }
}
