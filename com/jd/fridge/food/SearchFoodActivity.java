package com.jd.fridge.food;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jd.fridge.R;
import com.jd.fridge.a;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.SearchGoodsListBean;
import com.jd.fridge.bean.requestBody.SearchText;
import com.jd.fridge.util.o;
import com.jd.fridge.util.r;
import com.jd.fridge.util.x;
import com.jd.fridge.util.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: TbsSdkJava */
public class SearchFoodActivity extends BaseActivity implements TextWatcher, OnClickListener, OnItemClickListener, OnEditorActionListener {
    private List<SearchGoodsListBean> a = new ArrayList();
    private Timer b;
    @BindView(2131558630)
    ImageView backImageView;
    private TimerTask c;
    @BindView(2131558634)
    ImageView closeImageView;
    @BindView(2131558636)
    View dividerView;
    @BindView(2131558637)
    RelativeLayout noResultLayout;
    @BindView(2131558633)
    EditText searchEditText;
    @BindView(2131558635)
    ListView searchListView;

    protected int a() {
        return R.layout.activity_search_food;
    }

    protected void c() {
    }

    protected void b() {
        ButterKnife.bind((Activity) this);
        k();
        this.closeImageView.setVisibility(8);
        this.noResultLayout.setVisibility(8);
        this.noResultLayout.setOnClickListener(this);
        this.backImageView.setOnClickListener(this);
        this.closeImageView.setOnClickListener(this);
        this.searchEditText.setFocusable(true);
        this.searchEditText.setOnEditorActionListener(this);
        this.searchEditText.addTextChangedListener(this);
        this.searchListView.setOnItemClickListener(this);
        this.searchEditText.setOnClickListener(this);
        this.searchEditText.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ SearchFoodActivity a;

            {
                this.a = r1;
            }

            public void onFocusChange(View view, boolean z) {
                r.b("infos", "====hasFocus==" + z);
            }
        });
        e();
    }

    protected void d() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_food, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_food_back_imageView:
                o.c(this.searchEditText);
                finish();
                return;
            case R.id.search_food_search_editText:
                o.d(this.searchEditText);
                r.b("infos", "has=ssss==" + this.searchEditText.hasFocus());
                return;
            case R.id.search_food_close_imageView:
                this.e.postDelayed(new Runnable(this) {
                    final /* synthetic */ SearchFoodActivity a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        this.a.closeImageView.setVisibility(8);
                    }
                }, 200);
                this.searchListView.setVisibility(8);
                this.dividerView.setVisibility(8);
                this.noResultLayout.setVisibility(0);
                this.searchEditText.setText("");
                return;
            case R.id.search_food_no_result_layout:
                r.b("infos", "has===" + this.searchEditText.hasFocus());
                return;
            default:
                return;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.a.size()) {
            o.c(this.searchEditText);
            Intent intent = new Intent(this, FoodAddAlarmActivity.class);
            SearchGoodsListBean searchGoodsListBean = (SearchGoodsListBean) this.a.get(i);
            intent.putExtra("goods_name", searchGoodsListBean.getGoods_name());
            intent.putExtra("category_id", searchGoodsListBean.getCategory_id());
            intent.putExtra("goods_id", searchGoodsListBean.getGoods_id());
            setResult(-1, intent);
            finish();
        }
    }

    public boolean a(Message message) {
        int i = 0;
        switch (message.what) {
            case 7004:
                if (!TextUtils.isEmpty(this.searchEditText.getText().toString())) {
                    this.a.clear();
                    this.a = (List) message.obj;
                    this.searchListView.setVisibility(0);
                    this.dividerView.setVisibility(0);
                    List arrayList = new ArrayList();
                    int size = this.a.size();
                    if (size <= 0) {
                        o.d(this.searchEditText);
                        this.searchListView.setVisibility(8);
                        this.dividerView.setVisibility(8);
                        this.noResultLayout.setVisibility(0);
                        break;
                    }
                    while (i < size) {
                        arrayList.add(((SearchGoodsListBean) this.a.get(i)).getGoods_name());
                        i++;
                    }
                    this.searchListView.setAdapter(new ArrayAdapter(this, 17367043, arrayList));
                    this.noResultLayout.setVisibility(8);
                    break;
                }
                this.closeImageView.setVisibility(8);
                this.searchListView.setVisibility(8);
                this.dividerView.setVisibility(8);
                this.noResultLayout.setVisibility(8);
                break;
            case 7005:
                this.searchListView.setVisibility(8);
                this.dividerView.setVisibility(8);
                this.noResultLayout.setVisibility(0);
                break;
        }
        return super.a(message);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence.toString())) {
            this.closeImageView.setVisibility(8);
            this.searchListView.setVisibility(8);
            this.dividerView.setVisibility(8);
            return;
        }
        this.closeImageView.setVisibility(0);
        if (y.d((Context) this)) {
            a.a().a(this.e, new SearchText(charSequence.toString()));
            return;
        }
        x.a((Context) this, "网络断了哦，请检查网络设置");
    }

    public void afterTextChanged(Editable editable) {
    }

    private void e() {
        if (this.b == null) {
            this.b = new Timer();
        }
        this.c = new TimerTask(this) {
            final /* synthetic */ SearchFoodActivity a;

            {
                this.a = r1;
            }

            public void run() {
                o.d(this.a.searchEditText);
            }
        };
        this.b.schedule(this.c, 500);
    }

    private void f() {
        if (this.c != null) {
            this.c.cancel();
        }
        if (this.b != null) {
            this.b.cancel();
            this.b.purge();
            this.b = null;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        o.c(this.searchEditText);
        f();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
