package com.chentx.tables.module03.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * employee class,including warehouse keeper and warehouse manager
 *
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/2/18 18:02
 * @since JDK17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    /**
     * id
     */
    private int id;
    /**
     * 职工号
     */
    private String employeeNumber;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;

    /**
     * 职位，仓管员、经理
     */
    private String position;
    /**
     * 是否在职，默认在职
     */
    private Byte inOffice;
    /**
     * 性别
     */
    private Byte sex;
    /**
     * 年龄
     */
    private int age;
    /**
     * 联系方式
     */
    private String contact;
    /**
     * 薪资
     */
    private double salary;
    /**
     * 入职日期，yyyy-MM-dd，无法默认设置当前日期
     */
    private Date dateOfEntry;
    /**
     * 离职日期，yyyy-MM-dd，无法默认设置当前日期
     */
    private Date dateOfDeparture;

    public Employee(EmployeeBuilder employeeBuilder) {
        this.id = employeeBuilder.id;
        this.employeeNumber = employeeBuilder.employeeNumber;
        this.name = employeeBuilder.name;
        this.password = employeeBuilder.password;
        this.position = employeeBuilder.position;
        this.inOffice = employeeBuilder.inOffice;
        this.sex = employeeBuilder.sex;
        this.age = employeeBuilder.age;
        this.contact = employeeBuilder.contact;
        this.salary = employeeBuilder.salary;
        this.dateOfEntry = employeeBuilder.dateOfEntry;
        this.dateOfDeparture = employeeBuilder.dateOfDeparture;
    }

    @Data
    public static final class EmployeeBuilder {
        /**
         * id
         */
        private int id;
        /**
         * 职工号
         */
        private String employeeNumber;
        /**
         * 姓名
         */
        private String name;
        /**
         * 密码
         */
        private String password;
        /**
         * 职位，仓管员、经理
         */
        private String position;
        /**
         * 是否在职，默认在职
         */
        private Byte inOffice;
        /**
         * 性别
         */
        private Byte sex;
        /**
         * 年龄
         */
        private int age;
        /**
         * 联系方式
         */
        private String contact;
        /**
         * 薪资
         */
        private double salary;
        /**
         * 入职日期，yyyy-MM-dd，无法默认设置当前日期
         */
        private Date dateOfEntry;
        /**
         * 离职日期，yyyy-MM-dd，无法默认设置当前日期
         */
        private Date dateOfDeparture;


        /**
         * 配合anEmployee方法使用
         */
        private EmployeeBuilder() {
        }

        private EmployeeBuilder(String employeeNumber){
            this.employeeNumber = employeeNumber;
        }

        /**
         * 方便登录时使用
         * @param employeeNumber
         * @param password
         */
        private EmployeeBuilder(String employeeNumber, String password) {
            this.employeeNumber = employeeNumber;
            this.password = password;
        }

        /**
         * 声明了一个EmployeeBuilder对象,带有employeeNumber参数值
         * @param employeeNumber    职工号，是必传的参数
         * @return  声明了一个EmployeeBuilder对象，并给该对象的必需参数employeeNumber付了值
         */
        public static EmployeeBuilder create(String employeeNumber){
            return new EmployeeBuilder(employeeNumber);
        }

        /**
         * 单纯的声明了一个EmployeeBuilder，没有赋予任何参数值
         * @return this
         */
        public static EmployeeBuilder anEmployee() {
            return new EmployeeBuilder();
        }

        /**
         * 添加id,其实按道理是不需要这个的，因为id是数据库自动生成的
         * 写下来显得比较规范好看
         * @param id    id
         * @return  this
         */
        public EmployeeBuilder withId(int id) {
            this.id = id;
            return this;
        }

        /**
         * 添加职工号，配合anEmployee方法
         * @param employeeNumber    职工号
         * @return  this
         */
        public EmployeeBuilder withEmployeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        /**
         * 添加姓名
         * @param name  姓名
         * @return  this
         */
        public EmployeeBuilder withName(String name) {
            this.name = name;
            return this;
        }
        /**
         * 添加密码
         */
        public EmployeeBuilder withPassword(String password) {
            this.password = password;
            return this;
        }
        /**
         * 添加职位
         * @param position  职位
         * @return this
         */
        public EmployeeBuilder withPosition(String position) {
            this.position = position;
            return this;
        }
        /**
         * 确认状态，是否在职
         * @param inOffice  是否在职
         * @return  this
         */
        public EmployeeBuilder withInOffice(Byte inOffice) {
            this.inOffice = inOffice;
            return this;
        }
        /**
         * 添加性别
         * @param sex   性别
         * @return  this
         */
        public EmployeeBuilder withSex(Byte sex) {
            this.sex = sex;
            return this;
        }
        /**
         * 添加年龄
         * @param age   年龄
         * @return  this
         */
        public EmployeeBuilder withAge(int age) {
            this.age = age;
            return this;
        }
        /**
         * 添加联系方式
         * @param contact   联系方式
         * @return  this
         */
        public EmployeeBuilder withContact(String contact) {
            this.contact = contact;
            return this;
        }
        /**
         * 添加薪资
         * @param salary    薪资
         * @return  this
         */
        public EmployeeBuilder withSalary(double salary) {
            this.salary = salary;
            return this;
        }
        /**
         * 添加入职日期
         * @param dateOfEntry   入职日期
         * @return  this
         */
        public EmployeeBuilder withDateOfEntry(Date dateOfEntry) {
            this.dateOfEntry = dateOfEntry;
            return this;
        }
        /**
         * 添加离职日期
         * @param dateOfDeparture   离职日期
         * @return  this
         */
        public EmployeeBuilder withDateOfDeparture(Date dateOfDeparture) {
            this.dateOfDeparture = dateOfDeparture;
            return this;
        }
        /**
         * 确认创建对象
         * @return  this对象
         */
        public Employee build() {
            return new Employee(this);
        }
    }

}


/*
    attention，please：
    由于该实体类中的参数过多，在进行插入操作时由于大多数数据都属于在实际中必要的数据，因此如果使用之前用到的
    构造器方法就会导致再输入数据时需要我们一个个数据的去对，很烦人；
    而如果使用set和get方法时有会导致我们在封装数据时需要编写大量的代码，还是嫌烦，所以采用晚上推荐的builder方法，
    但此方法的性能在要求较高的情况下会有一些问题，不过对于目前说使用的对象而言有个毛的性能要求，所以在此采用了
    第三种方法来进行数据的封装

    等一下，我想一下，这种方法在目前的情况下好像能减少我一定的工作量，我先试试

 */