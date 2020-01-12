package com.shin.shinxbgalleryweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shin.shinxbgalleryweb.dao")
public class ShinxbGallerywebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShinxbGallerywebApplication.class, args);
	}

}
