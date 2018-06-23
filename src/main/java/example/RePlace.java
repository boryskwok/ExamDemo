package example;

public class RePlace {
    public String replaceSpace(StringBuffer str) {
        StringBuffer temp=new StringBuffer();
//         初始化类为实例对象
        for (int i=0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                temp.append("%20");
            }
            else
                temp.append(str.charAt(i));
        }
        return temp.toString();
    }
}
