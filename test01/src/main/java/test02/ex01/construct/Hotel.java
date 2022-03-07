package test02.ex01.construct;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Hotel {
	
	//@Resource(name="chef2")  //@Resource�� �̸��� �켱�Ѵ�. �̸��� �������� ������, Ÿ��
	
	@Autowired(required=false)
	@Qualifier("c2")
	private Chef chef;
	

	
	public Hotel(Chef chef) {
		this.chef = chef;
		System.out.println("Hotel���� DI�� Chef ��ü : "+this.chef);
	}


	
}