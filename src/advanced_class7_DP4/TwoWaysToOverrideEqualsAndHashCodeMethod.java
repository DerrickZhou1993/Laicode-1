package advanced_class7_DP4;

import java.util.Objects;

/**
 * 
 * @author @Yifeng
 * when we need to guarantee two objects are equal, we need to override this object class's 
 * equals() and hashCode() to make sure when invoke() o1.equals(o2), this could return true
 * for two objects with same semantic meaning of what we need
 * 
 * default hashCode() was based on object's address so we also need to override it
 */
public class TwoWaysToOverrideEqualsAndHashCodeMethod {
	/*
	 * Classic way to override equals() and hashCode
	 */
	public class User {
		private String name;
		private int age;
		private String passport;

		// getters and setters, constructor are left out
		
		@Override
		public boolean equals(Object o) {
			if (o == this) {
				return true;
			}
			if (!(o instanceof User)) {
				return false;
			}
			User user = (User) o;
			return user.name.equals(name) 
					&& user.age == age
					&& user.passport.equals(passport);
		}
		
		// 17 and 31 are common prime number used in hashCode()
		@Override
		public int hashCode() {
			int result = 17;
			result = 31 * result + name.hashCode();
			result = 31 * result + age;
			result = 31 * result + passport.hashCode();
			return result;
		}
	}
	
	
	/*
	 * Java 7 to override equals() and hashCode()
	 * For JDK 7 and above, you can use the new Objects 
	 * class to generate the equals and hash code values.
	 */
	public class User2 {
		private String name;
		private int age;
		private String passport;

		// getters and setters, constructor are left out
		
		@Override
		public boolean equals(Object o) {
			if (o == this) {
				return true;
			}
			if (!(o instanceof User2)) {
				return false;
			}
			User2 user2 = (User2) o;
			return user2.age == age 
					&& Objects.equals(user2.name, name)
					&& Objects.equals(user2.passport, passport);
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(name, age, passport);
		}
	}
}
