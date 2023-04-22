package org.example.attempt02;

/**
 * WarehouseManagementSystem
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/4/22 19:11
 * @since JDK17
 */

import java.sql.ResultSet;

public class PageNavigate {
    private ResultSet _rs = null;// 结果集

    private int _pageSize = 10;// 设置一页显示记录数目

    private int _currentPage = 1;// 当前页数

    private int _totalPage = 1;// 总页数

    private int _totalRecord = 0;// 总记录数目

    private String _toolBar = "";// 导航栏

    private String _currentPageName = "currentPage";// 当前页的参数名,默认为currentPage

    private String _toolBarFormName = "jumpPageFormName";// 导航栏的form名,jumpPageFormName+number

    private int i = 0;// 内部计数变量 如jumpPageFormName0,jumpPageFormName1 ...

    private String _toolBarHiddenField = "";// 表单隐藏字段

    private String _toolBarHiddenFieldHyperlink = "";// 超链接字段

    private String _toURLPage = "#";// 跳转的页面名字

    // 初始化对象
    public PageNavigate(){
    }

    /**
     * 设置跳转的页面
     *
     * @param name 默认为#,如index.jsp
     */
    public void setURLPage(String name) {
        _toURLPage = name;
    }

    /**
     * 设置当前页的表单名字
     *
     * @param name 默认为currentPage
     */
    public void setCurrentPageName(String name) {
        _currentPageName = name;
    }

    public int getTotalPage() {
        return _totalPage;
    }

    public int getTotalRecord() {
        return _totalRecord;
    }

    private void setParam() {
        if (_pageSize < 1) {
            _pageSize = 1;
        }
        // 计算总页数
        if (_totalRecord % _pageSize == 0) {
            _totalPage = _totalRecord / _pageSize;// 偶数页
        } else {
            _totalPage = (int) Math.floor(_totalRecord / _pageSize) + 1;// 奇数页
        }
        if (_totalPage <= 0) {
            _totalPage = 1;
        }
        if (_currentPage > _totalPage) {
            _currentPage = _totalPage;
        }
        if (_currentPage < 1) {
            _currentPage = 1;
        }
    }

    public void setParam(java.sql.ResultSet rs, int currentPage, int pageSize) throws Exception {
        try {
            _currentPage = currentPage;// 设置当前页数
            _pageSize = pageSize;// 设置一页显示记录数目
            _rs = rs;
            // 如果结果集为空
            if (_rs == null) {
                _totalRecord = 0;
            } else {
                _totalRecord = getRsCount(_rs);// 设置当前总记录数目
            }
            setParam();// 设置参数
        }
        catch (Exception ex) {
        }
    }

    /**
     * 获取记录集总数
     */
    public int getRsCount(java.sql.ResultSet rs) throws Exception {
        try {
            if (rs == null) {
                return 0;
            }
            // int nowRow = rs.getRow();// 取得当前位置
            rs.last();// 将指针指向最后
            int intRowCount = rs.getRow();// 取得结果集总数
            // rs.absolute(nowRow);// 复原指针
            return intRowCount;// 返回结果集数目
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * 返回导航栏,需先设置setURLPage(URLPage)
     *
     * @return
     */
    public String getToolBar() {
        return getToolBar(true, true, true, true);
    }

    /**
     * 跳转到URLPage的导航栏
     *
     * @param URLPage
     * @return
     */
    public String getToolBar(String URLPage) {
        setURLPage(URLPage);
        return getToolBar(true, true, true, true);
    }

    /**
     * 跳转到URLPage的导航栏
     *
     * @param URLPage
     * @param isCount 是否显示 共n条记录
     * @param isInformation 是否显示 第a/b页
     * @param isNavigate 是否显示 首页 上页 下页 尾页
     * @param isJumpPage 是否显示 跳到第[]页 GO
     * @return
     */
    public String getToolBar(String URLPage, boolean isCount, boolean isInformation, boolean isNavigate, boolean isJumpPage) {
        setURLPage(URLPage);
        return getToolBar(isCount, isInformation, isNavigate, isJumpPage);
    }

    /**
     * 返回导航栏,需先设置setURLPage(URLPage)
     *
     * @param isCount 是否显示 共n条记录
     * @param isInformation 是否显示 第a/b页
     * @param isNavigate 是否显示 首页 上页 下页 尾页
     * @param isJumpPage 是否显示 跳到第[]页 GO
     * @return
     */
    public String getToolBar(boolean isCount, boolean isInformation, boolean isNavigate, boolean isJumpPage) {
        i++;
        String _formP = Integer.toString(i);
        String _tR = (String) (Integer.toString(_totalRecord));
        String _tP = (String) (Integer.toString(_totalPage));
        String _currPage = (String) (Integer.toString(_currentPage));
        String _prevPage = (String) (Integer.toString(_currentPage - 1));
        String _nextPage = (String) (Integer.toString(_currentPage + 1));
        // 开头
        _toolBar = "\n\n"
                + "<table width='100%' border='0' cellpadding='0' cellspacing='0'>\n"
                + "<form name='" + _toolBarFormName + _formP
                + "' method='post' action='" + _toURLPage + "' >\n"
                + "<tr align='right'>\n"
                + "<td valign='bottom' align='right' nowrap='true'>\n";
        // ***********共n条记录***********
        if (isCount) {
            _toolBar += "共" + _tR + "条记录&nbsp;";
        }
        // ***********第a/b页***********
        if (isInformation) {
            _toolBar += "第" + _currPage + "/" + _tP + "页&nbsp";
        }
        // ***********首页 上页 下页 尾页***********
        if (isNavigate) {
            // ***********首页***********
            _toolBar += "<a";
            if (_currentPage == 1) {
                _toolBar += " disabled='true'";
            } else {
                _toolBar += " href='" + _toURLPage + "?" + _currentPageName
                        + "=1" + _toolBarHiddenFieldHyperlink + "'";
            }
            _toolBar += "><font color=\"#0000ff\">首页</font></a>&nbsp;";
            //
            // ***********上页***********
            _toolBar += "<a";
            if (_currentPage == 1) {
                _toolBar += " disabled='true'";
            } else {
                _toolBar += " href='" + _toURLPage + "?" + _currentPageName
                        + "=" + _prevPage + _toolBarHiddenFieldHyperlink + "'";
            }
            _toolBar += "><font color=\"#0000ff\">上页</font></a>&nbsp;";
            //
            // ***********下页***********
            _toolBar += "<a";
            if (_currentPage == _totalPage || _totalPage == 1) {
                _toolBar += " disabled='true'";
            } else {
                _toolBar += " href='" + _toURLPage + "?" + _currentPageName
                        + "=" + _nextPage + _toolBarHiddenFieldHyperlink + "'";
            }
            _toolBar += "><font color=\"#0000ff\">下页</font></a>&nbsp;";
            //
            // ***********尾页***********
            _toolBar += "<a";
            if (_currentPage == _totalPage || _totalPage == 1) {
                _toolBar += " disabled='true'";
            } else {
                _toolBar += " href='" + _toURLPage + "?" + _currentPageName
                        + "=" + _tP + _toolBarHiddenFieldHyperlink + "'";
            }
            _toolBar += "><font color=\"#0000ff\">尾页</font></a>&nbsp;\n";
        }
        //
        // ***********跳到第[]页 GO***********
        if (isJumpPage) {
            _toolBar += "跳到第<input type='text' value='" + _currPage
                    + "' name='" + _currentPageName + "' size='2' ";
            if (_totalPage == 1) {
                _toolBar += " readonly='true'";
            }
            _toolBar += "/>页\n";
            _toolBar += "<input type='submit' name='submit' value='GO'";
            // if (_totalPage == 1){_toolBar += " disabled='true'";}else{
            _toolBar += " onClick=\"javascript:"
                    + "v=document."
                    + _toolBarFormName
                    + _formP
                    + "."
                    + _currentPageName
                    + ".value;"
                    + "if(v.indexOf('.')==-1 && v.indexOf('-')==-1 && v!='' && !isNaN(v) && v!=0 && v!="
                    + _currentPage + ")" + "{return true;}return false;\"";
            // }
            _toolBar += " />\n";
        }
        // 结尾
        _toolBar += "</td>\n" + "</tr>\n" + "</form>\n" + _toolBarHiddenField
                + "</table>" + "\n\n";
        return _toolBar;
    }

    /**
     * 添加隐藏字段
     * @param hiddenName
     * @param hiddenValue
     */
    public void addHiddenField(String hiddenName, String hiddenValue) {
        _toolBarHiddenField += "<input type='hidden' name='" + hiddenName
                + "' value='" + hiddenValue + "' />" + "\n";
        _toolBarHiddenFieldHyperlink += "&" + hiddenName + "=" + hiddenValue;
    }
}