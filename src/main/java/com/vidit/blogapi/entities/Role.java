package com.vidit.blogapi.entities;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class Role {

	@Id	
	private int id;
	
	private String name;
	
}
