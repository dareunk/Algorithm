class Solution {
    public String solution(String new_id) {
        String answer = new KAKAOID(new_id)
				.replaceToLowerCase()
				.filter()
                .toRemoveDot()
                .noStartEndDot()
                .noBlank()
                .checkLength()
                .noLessThan2()
                .getResult();
        return answer;
    }
    private static class KAKAOID{
		private String s;
		
		KAKAOID(String s){
			this.s = s;
		}
		private KAKAOID replaceToLowerCase() {
			s = s.toLowerCase();
			return this;
		}
		private KAKAOID filter() {
			s = s.replaceAll("[^a-z0-9._-]", "");
			return this;
		}
		private KAKAOID toRemoveDot() {
			s = s.replaceAll("[.]{2,}",".");
			return this;
		}
		private KAKAOID noStartEndDot() {
			s = s.replaceAll("^[.]|[.]$", "");
			return this;
		}
		private KAKAOID noBlank() {
			s = s.isEmpty()? "a":s;
			return this;
		}
		private KAKAOID checkLength() {
			if(s.length()>=16) s = s.substring(0,15);
			s = s.replaceAll("[.]$", "");
			return this;
		}
		private KAKAOID noLessThan2() {
			while(s.length()<3) {
				s += s.charAt(s.length()-1);
			}
			return this;
		}
		private String getResult() {
			return s;
		}
		
	}

}