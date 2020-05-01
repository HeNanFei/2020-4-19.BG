import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjt.common.api.CommonPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class PageTest {
    public static List pageInfo(List list,Integer pageIndex,Integer pageSize){

        //CommonPage commonPage = new CommonPage();
        CommonPage commonPage = CommonPage.restPage(list);
        commonPage.setPageNum(pageIndex);
        commonPage.setPageSize(pageSize);
        commonPage.setTotal((long) list.size());
        commonPage.setTotalPage(list.size());

        PageHelper.startPage(pageIndex,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        /* List<String> list = new ArrayList<>();

        for(int i =0;i<10;i++){
            list.add("元素"+i);
        }
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<String> pageInfo = new PageInfo(list);

        return pageInfo.toString();*/

        return pageInfo.getList();

    }
    public static void main(String[] args) {
        List<String> list2 = new ArrayList<>();

        for(int i =0;i<10;i++){
            list2.add("元素"+i);
        }
        List list1 = pageInfo(list2, 1, 5);

        list1.stream().forEach(n -> System.out.println("第一次"+n));

        List list = pageInfo(list2, 2, 9);

        list.stream().forEach(n -> System.out.println("第二次"+n));

        //System.out.println("第二次"+);
    }
}
