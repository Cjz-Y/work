package com.ruangong.work.Controller;

import com.ruangong.work.Bean.Account;
import com.ruangong.work.Bean.Ban;
import com.ruangong.work.Bean.BanToCourse;
import com.ruangong.work.Bean.Course;
import com.ruangong.work.Bean.temp.TempAccount;
import com.ruangong.work.Service.AccountService;
import com.ruangong.work.Service.BanService;
import com.ruangong.work.Service.BanToCourseService;
import com.ruangong.work.common.DataProcessUtils;
import com.ruangong.work.common.ImportExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ban")
public class BanController {

    @Autowired
    private BanService banService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private BanToCourseService banToCourseService;

    /**
     * 展示学生名单
     * @param banId
     * @return
     */
    @RequestMapping(value = "/showStudent", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> showStudentByBanId(Integer banId){
        List<Account> result = accountService.findStudentsByBanId(banId);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        return map;
    }

    /**
     * 班级主页面
     * @param banId
     * @param modelMap
     * @return
     */
    @RequestMapping("/ban")
    public String showPage(Integer banId, ModelMap modelMap){
        Ban ban = banService.findById(banId.longValue());
        modelMap.put("ban", ban);
        return "views/ban/ban";
    }

    /**
     * 展示添加学生的页面
     * @param banId
     * @param modelMap
     * @return
     */
    @RequestMapping("/addStudentPage")
    public String showAddStudentPage(Integer banId, ModelMap modelMap){
        modelMap.put("banId", banId);
        return "views/ban/add_student_page";
    }

    /**
     * 添加学生
     * @param student
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/addStudent")
    public String addStudent(Account student, RedirectAttributes redirectAttributes){
        Account student1 = accountService.save(student);
        redirectAttributes.addAttribute("banId", student.getBanId());
        return "redirect:/ban/ban";
    }

    /**
     * 导入excel
     * @param file  上传的excel文件
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/uploadExcelData",method = RequestMethod.POST)
    public void uploadExcelData(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        List<Ban> banList = banService.findAll();
        Map<String, Long> banDict = banList.stream().collect(Collectors.toMap(Ban::getName, Ban::getId));
        String filePath = ImportExcelUtil.uploadExcelData(file, response);
        new Thread() {
            @Override
            public void run() {
                List<Object> data = ImportExcelUtil.readExcel(filePath, TempAccount.class);
                List<Account> realData = DataProcessUtils.processStudentData(data, banDict);
                Iterator iterator = realData.iterator();
                while (iterator.hasNext()){
                    accountService.save((Account) iterator.next());
                }
            }
        }.start();
    }

}
