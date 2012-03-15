package pl.szkolenie;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import pl.szkolenie.service.ImageRepo;

public class Consumer {
	public static void main(String[] args) throws IOException {
		try {
			URL wsdlLocation = new URL("http://localhost:8080/m3_cw4_server/ImageRepoImplService?wsdl");
			QName serviceName = new QName("http://service.szkolenie.pl/", "ImageRepoImplService");
			QName portName = new QName("http://service.szkolenie.pl/", "ImageRepoImplPort");
			Service service = Service.create(wsdlLocation, serviceName);
			ImageRepo imageRepo = service.getPort(portName, ImageRepo.class);
			
			String name = "Actions-list-add-font-icon.png";
			imageRepo.put(name, ImageIO.read(new File(name)));
			Image im = imageRepo.getImage(name);
			
			File f = new File("download.png");
			ImageIO.write((RenderedImage) im, "png", new FileOutputStream(f));

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
