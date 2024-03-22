package dmacc.beans;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * Audrey N. Johnston - ajohnston10
 * CIS175
 * Mar 5, 2024
 */

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter 
@Setter
@Entity
public class Pet {

		@Id
		@GeneratedValue
		private int id;
		private String type;
		private String name;
		private String owner;
		
		public Pet (String type, String name, String owner) {
			super();
			this.type = type;
			this.name = name;
			this.owner = owner;
		}
}






	
	
	

