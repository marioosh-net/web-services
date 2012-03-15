package pl.szkolenie.service;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

@WebService
@MTOM
public class ImageRepoImpl implements ImageRepo {

	@Override
	public Image getImage(String name) {
		File image = new File(".\\" + name);
		try {
			return ImageIO.read(image);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void put(String name, Image image) {
		File file = new File(".\\"+name);
		if(file.exists()) {
			throw new ImageExistException();
		}
		try {
			ImageIO.write((RenderedImage) image, "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
