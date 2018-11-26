package ca.paruvendu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.paruvendu.resource.BookResource;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ParuvenduAngularApplicationTests {

	@Autowired
	private BookResource controller;
	
//    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

}
