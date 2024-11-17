package com.ecommerce.users.exception;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AbstractError {
	public AbstractError(String description) {
		super();
		this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		this.description = description;
	}
	public String timestamp;
	public String description;
}
