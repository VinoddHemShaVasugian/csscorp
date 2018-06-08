package regex;

import java.util.regex.Pattern;

public class RegularExpression_Character {

	public static void main(String[] args) {
//		System.out.println(Pattern.matches("[amn]", "abcd"));//false (not a or m or n)  
//		System.out.println(Pattern.matches("[amn]", "a"));//true (among a or m or n)  
//		System.out.println(Pattern.matches("[amn]", "ammmna"));//false (m and a comes more than once)
//		System.out.println(Pattern.matches("[abcd]", "b"));
//		System.out.println(Pattern.matches("[^abcd]", "5"));
//		System.out.println(Pattern.matches("[a-zA-Z]", "Z"));
		String s="bv";
//		System.out.println(Pattern.matches("[a-dm-p0-5$]", s));
		System.out.println(Pattern.matches("[amn]?", s));
		System.out.println(Pattern.matches("[amn]+", s));
		System.out.println(Pattern.matches("[amn]*", s));
//		System.out.println(Pattern.matches("[amn]?", s));
		}
}
