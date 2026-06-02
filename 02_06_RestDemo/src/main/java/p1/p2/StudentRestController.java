package p1.p2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
	@Value("${student.name}")
	private String name;
	private String subject;

	public void setName(String name) {
		this.name = name;
	}

	@Value("${student.subject}")
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@GetMapping("/info")
	public String toString() {
		return "Studen " + name + "  " + subject ;
	}
	

}
