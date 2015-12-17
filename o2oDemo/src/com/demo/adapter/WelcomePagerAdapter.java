package com.demo.adapter;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.demo.xiamenhome.R;
import com.loonandroid.pc.adapter.ViewHolder;
import com.loonandroid.pc.interfaces.LoonAdapter;

/**
 * 
 * 当前为自动注入的适配器<br>
 * <h1>以下为需要注意的</h1> 写法分为两种<br>
 * 1 WelcomePagerAdapter 实现LoonAdapter接口，并声明LoonAdapter接口的泛型 该泛型为你绑定到该Item的来源数据的类型<br>
 * 2 如果你不实现LoonAdapter接口，当这个适配器注入的时候 也会自动实现LoonAdapter接口， 那么你在使用的时候，就必须强转<br>
 * ----------------------------------------------- <br>
 * oooO............... <br>
 * (....) ... Oooo... <br>
 * .\..(.....(.....)....... <br>
 * ..\_)..... )../........ <br>
 * .......... (_/.......... <br>
 * 微信 gdpancheng <br>
 * -----------------------------------------------
 * 
 * @author gdpancheng@gmail.com 2014年12月15日 上午10:30:12
 */
public abstract class WelcomePagerAdapter extends BaseAdapter implements LoonAdapter {

	View.OnClickListener l;

	/**
	 * 因为是静态数据源 所以要手动设置count
	 */
	@Override
	public int getCount() {
	    return 4;
	}
	
	@Override
	public boolean dealView(Object arg0, ViewHolder arg1) {
		ImageButton button = arg1.getView(R.id.button);
		ImageView imageView = arg1.getView(R.id.photo);
		button.setVisibility(View.GONE);
		switch (arg1.getPosition()) {
		case 0:
			imageView.setImageResource(R.drawable.welcome1);
			break;

		case 1:
			imageView.setImageResource(R.drawable.welcome2);
			break;

		case 2:
			imageView.setImageResource(R.drawable.welcome3);
			break;

		case 3:
			imageView.setImageResource(R.drawable.welcome4);
			button.setVisibility(View.VISIBLE);
			button.setOnClickListener(l);
			break;
		}
		return true;
	}

	public void setL(View.OnClickListener l) {
		this.l = l;
	}

}
