package utillity;

public class MakeDemoData {
    FileOperator foe = new FileOperator();
    TypeSettingUtils type = new TypeSettingUtils();
    public MakeDemoData(){
        runTask2();
    }
    public void runTask1(){
        String msg = foe.LoadData("assets/input.txt");
        msg = msg.replace('\n',' ');
        String [] sp = msg.split(" ",-1);
        type.setFormatComma(true);
        type.setFormateNumber(false);
        type.setFormatQuotationMarks(false);
        type.setNextLine(8);
        msg = type.showStringArray(sp);
        System.out.println(msg);
    }
    public void runTask2(){
        int m=10;
        int n=8;
        StringBuffer sb = new StringBuffer(512);
        int index = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sb.append(index + " , ");
                index++;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void main(String args[]){
        new MakeDemoData();
    }
}
