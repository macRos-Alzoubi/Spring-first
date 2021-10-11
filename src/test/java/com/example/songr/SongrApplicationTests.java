package com.example.songr;

import com.example.songr.model.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

    @Test
    public void constructorTest() {
        Album album = new Album("War Zone", "The Wanted",
                "https://images-na.ssl-images-amazon.com/images/I/61Vdrtp2EeL.jpg",
                5, 360);
        assertEquals("War Zone", album.getTitle(), "Constructor should initialize the object with the data passed into it");
    }

	@Test
	public void testSetters(){
		Album album = new Album("War Zone", "The Wanted",
				"https://images-na.ssl-images-amazon.com/images/I/61Vdrtp2EeL.jpg",
				5, 360);
		album.setArtist("harrypotter");
		assertEquals("harrypotter", album.getArtist(), "The method should set the attribute with the data passed into it");
	}

	@Test
	public void testGetters(){
		Album album = new Album("War Zone", "The Wanted",
				"https://images-na.ssl-images-amazon.com/images/I/61Vdrtp2EeL.jpg",
				5, 360);

		assertEquals("The Wanted", album.getArtist());
	}
}
