package pl.szkolenie;

import javax.ws.rs.ApplicationPath;

import com.sun.jersey.api.core.PackagesResourceConfig;

@ApplicationPath("/rest")
public class RestApp extends PackagesResourceConfig {
	public RestApp() {
		super("pl.szkolenie.service");
	}
}
