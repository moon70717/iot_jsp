package conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.iot.test.common.MybatisSessionFactory;
import com.iot.test.vo.Customer;

public class Exam2 {

	public static void main(String[]args) {
		SqlSessionFactory ssf=MybatisSessionFactory.getSqlSessionFactroy();
		SqlSession ss=ssf.openSession();
		
		Customer c=new Customer();
		c.setCustomerName("김명재");
		c.setCustomerId(1);
		System.out.println(ss.update("customer.updateCustomer",c));
		ss.commit();
		
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("str", "customerId desc");
		List<Customer> cList=ss.selectList("customer.selectCustomer", map);
		for(Customer ct:cList) {
			System.out.println(ct);
		}
		
		
		
		
	}
}
