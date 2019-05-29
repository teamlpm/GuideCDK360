package com.devhwang1312.cdk360.Model;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    public String className,skillName,detail,type;
    public int noiluc,countDownTime;

    public Skill(String className, String skillName, String detail, String type, int noiluc, int countDownTime) {
        this.className = className;
        this.skillName = skillName;
        this.detail = detail;
        this.type = type;
        this.noiluc = noiluc;
        this.countDownTime = countDownTime;
    }

    public Skill() {
    }

    public void listSkill(){
        List<Skill> skillList = new ArrayList<>();
        skillList.add(new Skill("Học Sĩ","Hạo Nhiên Khí","Gây sát thương ngẫu nhiên cho 5 mục tiêu đối phương. Tăng sát thương bạo kích " +
                "bản thân sau khi sử dụng","Đánh nhóm phạm vi lớn, có tỉ lệ xóa hiệu ứng có lợi của kẻ địch",100,2));
        skillList.add(new Skill("Học Sĩ","Tập Kích","Gây sát thương cho 3 mục tiêu đối phương có chỉ số phòng ngự cao nhất. Có tỉ lệ giảm phòng thủ " +
                "đối phương","Đánh nhóm phạm vi nhỏ, giảm phòng thủ đối phương",30,3));
        skillList.add(new Skill("Học Sĩ","Kính Luân","Gây sát thương ngẫu nhiên cho 4 mục tiêu đối phương. Tăng bạo kích " +
                "bản thân sau khi sử dụng","Đánh nhóm phạm vi lớn, tăng bạo kích bản thân",30,4));
        skillList.add(new Skill("Học Sĩ","Họa Giang Sơn","Gây sát thương ngẫu nhiên cho 5 mục tiêu đối phương có chỉ số phòng ngự cao nhất. Tăng sát thương bạo kích " +
                "bản thân sau khi sử dụng","Đánh nhóm phạm vi lớn, tăng sát thương bạo kích",33,4));

        skillList.add(new Skill("Thị Vệ","Quân Tử Kiếm","Bỏ qua phòng thủ và ngây sát thương ngẫu nhiên cho 1 mục tiêu đối phương. " +
                "Tăng bạo kích bản thân sau khi sử dụng","Gây sát thương, bỏ qua phòng thủ và tăng bạo kích bản thân",100,2));
        skillList.add(new Skill("Thị Vệ","Kiếm Tâm","Gây sát thương ngẫu nhiên cho 1 mục tiêu đối phương. Tăng tấn công " +
                "và phục hổi sinh lực bản thân","Gây sát thương, tăng tấn công và phục hồi sinh lực bản thân",30,4));
        skillList.add(new Skill("Thị Vệ","Ảnh Lục","Gây sát thương ngẫu nhiên cho 3 mục tiêu đối phương. " +
                "Miễn nhiễm hiệu ứng xấu","Đánh nhóm phạm vi nhỏ, miễn dịch hiệu ứng",27,3));
        skillList.add(new Skill("Thị Vệ","Đơn Đao Hội","Gây sát thương ngẫu nhiên cho 1 mục tiêu đối phương. " +
                "Giảm phòng thủ và choáng mục tiêu","Gây sát thương, giảm phòng thủ và choáng mục tiêu",30,3));

        skillList.add(new Skill("Thượng Dược","Nhiếp Tâm Phách","Gây sát thương và có tỉ lệ hỗn loạn ngẫu nhiên cho 4 mục tiêu đối phương. Giảm kháng bạo mục tiêu " +
                "bản thân tăng phòng thủ","Gây sát thương và hỗn loạn mục tiêu, bản thân tăng phòng thủ",100,2));
        skillList.add(new Skill("Thượng Dược","Ma Phi Châm","Gây sát thương và giảm sinh lực cho 3 mục tiêu đối phương có chỉ số phòng thủ cao nhất."
                ,"Đánh nhóm phạm vi nhỏ, giảm sinh lực đối phương",27,4));
        skillList.add(new Skill("Thượng Dược","Lồng Giam Giữ","Gây sát thương và câm lặng ngẫu nhiên cho 1 mục tiêu đối phương. " +
                "Giảm sát thương bản thân nhận vào","Gây sát thương câm lặng mục tiêu",30,4));
        skillList.add(new Skill("Thượng Dược","Tửu Hương","Gây sát thương và câm lặng ngẫu nhiên cho 1 mục tiêu đối phương. " +
                "Giảm sát thương bản thân nhận vào","Gây sát thương câm lặng mục tiêu",30,4));

        skillList.add(new Skill("Thượng Thực","Thực Trung Tiên","Tạo 1 lớp khiên ngẫu nhiên cho 5 đồng đội kèm hiệu quả miễn dịch "
                ,"Tạo 1 lớp khiên và hồi máu cho đồng đội kèm hiệu quả miễn dịch",100,2));
        skillList.add(new Skill("Thượng Thực","Diệu Thủ Hồi Xuân","Hồi máu cho 4 đồng đội có sinh lực thấp nhất dựa trên sát thương gây ra "
               ,"Hồi máu cho đồng đội",30,4));
        skillList.add(new Skill("Thượng Thực","Lô Hỏa","Gây sát thương ngẫu nhiên cho 4 mục tiêu đối phương. Hồi sinh 1 mục tiêu phe ta" +
                "có mức sinh lực thấp nhất","Gây sát thương và hồi máu cho đồng đội có mức sinh lực thấp nhất",27,3));
        skillList.add(new Skill("Thượng Thực","Thao Thiết Tu","Hồi sinh ngẫu nhiên 1 đồng đội phe ta và hồi 1 lượng máu nhất định sau khi hồi sinh"
                ,"Hồi sinh đồng đội kèm hiệu quả hồi máu",27,8));
    }


}
