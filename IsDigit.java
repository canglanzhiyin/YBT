package dvd;
public class IsDigit {
	public boolean isDigit(String s){
		if(s.length()>10)
			return false;
		try{
			Integer.parseInt(s);
			return true;
		}catch (Exception e){
			try{
				Double.parseDouble(s);
				return true;
			}catch (Exception e1){
				try {
					Float.parseFloat(s);
					return true;
				}catch (Exception e2){
					return false;
				}
			}
		}
	}
}
