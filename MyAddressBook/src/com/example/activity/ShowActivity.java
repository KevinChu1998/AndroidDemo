package com.example.activity;

import com.example.contacts.R;
import com.example.util.MessageDAO;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends Activity {
 
	TextView name;
	EditText mobile,family,office,addr;
	Spinner sp;
	MessageDAO md;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		md=new MessageDAO(ShowActivity.this);
		
		
		name=(TextView)findViewById(R.id.show_name);
		mobile=(EditText)findViewById(R.id.mobile_num);
		family=(EditText)findViewById(R.id.family_num);
		office=(EditText)findViewById(R.id.office_num);
		sp=(Spinner)findViewById(R.id.show_group);
		addr=(EditText)findViewById(R.id.show_addr);
		
		Intent intent=getIntent();
		name.setText(intent.getStringExtra("name"));
		mobile.setText(intent.getStringExtra("mobile_num"));
		family.setText(intent.getStringExtra("family_num"));
		office.setText(intent.getStringExtra("office_num"));
		sp.setSelection(ChangetoId(intent.getStringExtra("groups").toString()));
		addr.setText(intent.getStringExtra("address"));
	}
	public int ChangetoId(String s)
	{
	int number = 0;
		if(s.equals("����"))
			number=0;

		else if(s.equals("ͬ��"))
			number=1;

		else if(s.equals("����"))
			number=2;

		else if(s.equals("ͬѧ"))
			number=3;
		return number;
	}
	public void onClick(View v)
    { 
		String str=mobile.getText().toString();
    	switch(v.getId()){
    	case R.id.call:
    		//Toast.makeText(ShowActivity.this,"�޸ĳɹ�", Toast.LENGTH_LONG).show();
    		Intent phoneintent=new Intent("android.intent.action.CALL",
					Uri.parse("tel:"+str));
			startActivity(phoneintent);
    		break;
    	case R.id.message:
    		Intent mesintent=new Intent(ShowActivity.this,SmsActivity.class);
    		mesintent.putExtra("contact", name.getText().toString());
    		mesintent.putExtra("number", mobile.getText().toString());
    		startActivity(mesintent);
    		/*Uri uri=Uri.parse("smsto:"+mobile.getText().toString());
    		Intent mesintent=new Intent(Intent.ACTION_SENDTO,uri);
    		startActivity(mesintent);*/
    		break;
    	case R.id.save_edit:
    		String str1,str2;
    		str1=name.getText().toString();
    		str2="set mobilephone='"+mobile.getText().toString()+"',familyphone='"+family.getText().toString()+
    				"',address='"+addr.getText().toString()+"',groups='"+sp.getSelectedItem()+"',officephone='"+office.getText().toString()+"'";
    		//Toast.makeText(ShowActivity.this, "update person "+str2+" where name='"+str1+"'", Toast.LENGTH_LONG).show();
			
            if(md.update(str1,str2))
				Toast.makeText(ShowActivity.this,"�޸ĳɹ�", Toast.LENGTH_LONG).show();
    	    break;
    	case R.id.delete:
    		AlertDialog.Builder builder = new Builder(this);
    		//���öԻ������
    		builder.setTitle("����");
    		//���öԻ����ڵ��ı�
    		builder.setMessage("ȷ��ɾ������ϵ�ˣ�");
    		//����ȷ����ť��������ť����һ���������
    		builder.setPositiveButton("ȷ��", new OnClickListener() {
    		        @Override
    		        public void onClick(DialogInterface dialog, int which) {
    		                // ִ�е��ȷ����ť��ҵ���߼�
    		        	if(md.Delete("name='"+name.getText().toString()+"' and mobilephone='"+mobile.getText().toString()+"'"))
    		        	Toast.makeText(ShowActivity.this,"ɾ���ɹ�", Toast.LENGTH_LONG).show();
    		    		Intent i=new Intent(ShowActivity.this,MainActivity.class);
    		    		startActivity(i);
    		        }
    		});
    		//����ȡ����ť
    		builder.setNegativeButton("ȡ��", new OnClickListener() {
    		        @Override
    		        public void onClick(DialogInterface dialog, int which) {
    		                // ִ�е��ȡ����ť��ҵ���߼�
    		        }
    		});
    		//ʹ��builder�������Ի������
    		AlertDialog dialog = builder.create();
    		//��ʾ�Ի���
    		dialog.show();
    		break;
    	case R.id.re_back:
    		finish();
    		break;
    	}
    	
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
