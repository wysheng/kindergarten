<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>幼儿园管理系统</title>
</head>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #F8F9FA;
}
-->
</style>

<link href="/kindergarten/pages/images/skin.css" rel="stylesheet" type="text/css" />
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" height="29" valign="top" background="images/mail_leftbg.gif"><img src="/kindergarten/pages/images/left-top-right.gif" width="17" height="29" /></td>
    <td width="935" height="29" valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">»ù±¾ÉèÖÃ</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="/kindergarten/pages/images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td height="71" valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="100%" height="138" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="13" valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td valign="top"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td class="left_txt">µ±Ç°Î»ÖÃ£º»ù±¾ÉèÖÃ</td>
          </tr>
          <tr>
            <td height="20"><table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
              <tr>
                <td></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" height="55" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="10%" height="55" valign="middle"><img src="/kindergarten/pages/images/title.gif" width="54" height="55"></td>
                <td width="90%" valign="top"><span class="left_txt2">ÔÚÕâÀï£¬Äú¿ÉÒÔ¸ù¾ÝÄúµÄÍøÕ¾ÒªÇó£¬ÐÞ¸ÄÉèÖÃÍøÕ¾µÄ</span><span class="left_txt3">»ù±¾²ÎÊý</span><span class="left_txt2">£¡</span><br>
                          <span class="left_txt2">°üÀ¨</span><span class="left_txt3">ÍøÕ¾Ãû³Æ£¬ÍøÖ·£¬ÍøÕ¾±¸°¸ºÅ£¬ÁªÏµ·½Ê½£¬ÍøÕ¾¹«¸æ£¬¹Ø¼ü´Ê£¬·ç¸ñ</span><span class="left_txt2">µÈÒÔ¼°ÍøÕ¾</span><span class="left_txt3">»áÔ±¼°µÈ¼¶»ý·ÖÉèÖÃ</span><span class="left_txt2">¡£ </span></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
              <tr>
                <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;ÏµÍ³²ÎÊýÉèÖÃ</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
			<form name="form1" method="POST" action="admintitlechk.asp">
              <tr>
                <td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">Éè¶¨ÍøÕ¾Ãû³Æ£º</td>
                <td width="3%" bgcolor="#f2f2f2">&nbsp;</td>
                <td width="32%" height="30" bgcolor="#f2f2f2"><input name="title" type="text" id="title" size="30" /></td>
                <td width="45%" height="30" bgcolor="#f2f2f2" class="left_txt">ÍøÕ¾Ãû³Æ</td>
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">ÍøÕ¾·ÃÎÊµØÖ·£º</td>
                <td>&nbsp;</td>
                <td height="30"><input type="text" name="web" size="30" /></td>
                <td height="30" class="left_txt">ÍøÕ¾µÄÍøÖ·</td>
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">ÍøÕ¾±¸°¸Ö¤ºÅ£º</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><input type="text" name="logo" size="25" /></td>
                <td height="30" bgcolor="#f2f2f2" class="left_txt">ÐÅÏ¢²úÒµ²¿±¸°¸ºÅ</td>
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">ÁªÏµµç»°ÐÅÏ¢£º </td>
                <td>&nbsp;</td>
                <td height="30"><input type="text" name="tel" size="30" /></td>
                <td height="30" class="left_txt">ÉèÖÃÍøÕ¾ÁªÏµµç»°</td>
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">ÍøÕ¾¿Í·þQQ£º</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><input type="text" name="myqq" size="30" /></td>
                <td height="30" bgcolor="#f2f2f2" class="left_txt">ÉèÖÃÍøÕ¾¿Í·þQQºÅ</td>
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#F7F8F9" class="left_txt2">ÍøÕ¾¿Í·þQQ2£º</td>
                <td bgcolor="#F7F8F9">&nbsp;</td>
                <td height="30" bgcolor="#F7F8F9"><input type="text" name="myqq2" size="30" /></td>
                <td height="30" bgcolor="#F7F8F9" class="left_txt">ÉèÖÃÍøÕ¾¿Í·þQQ2ºÅ</td>
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#F2F2F2" class="left_txt2">¹ÜÀíÔ±ÓÊÏä£º</td>
                <td bgcolor="#F2F2F2">&nbsp;</td>
                <td height="30" bgcolor="#F2F2F2"><input name="mymail" type="text" id="mymail" size="30" /></td>
                <td height="30" bgcolor="#F2F2F2"><span class="left_txt">ÉèÖÃÍøÕ¾¿Í·þEmail</span></td>
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">ÍøÕ¾¹ö¶¯Í¨Öª£º</td>
                <td>&nbsp;</td>
                <td height="30"><input type="text" name="addinfo" size="30" /></td>
                <td height="30"><span class="left_txt">ÉèÖÃÍøÕ¾¹ö¶¯¹«¸æÄÚÈÝ£¬Ö§³ÖHTML</span></td>
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">¹Ø¼ü´ÊÉèÖÃÎª£º </td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><input type="text" name="ci" size="30" /></td>
                <td height="30" bgcolor="#f2f2f2"><span class="left_txt">ÉèÖÃÍøÕ¾µÄ¹Ø¼ü´Ê£¬¸üÈÝÒ×±»ËÑË÷ÒýÖ¿ÕÒµ½¡£</span></td>
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">ÊÇ·ñ¿ªÆô¸´ÖÆ¹¦ÄÜ£º</td>
                <td>&nbsp;</td>
                <td height="30"><input type="text" name="kkk" size="4" /></td>
                <td height="30" class="left_txt">ÊÇ·ñ½ûÖ¹Íâ²¿¸´ÖÆ¹¦ÄÜ 0¹Ø±Õ£¬1¿ªÆô</td>
              </tr>
              <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">ÍøÕ¾·ç¸ñÉèÖÃ£º</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><input type="text" name="css" size="24" /></td>
                <td height="30" bgcolor="#f2f2f2" class="left_txt">Î²²¿¼Ó/ CSSÑùÊ½¶¨ÒåÄÚÈÝÓÃ</td>
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">³ÌÐòÊÚÈ¨×¢²áÂë£º</td>
                <td>&nbsp;</td>
                <td height="30"><input name="zhengban" type="text" id="zhengban" size="24" /></td>
                <td height="30" class="left_txt">ÍøÕ¾Õý°æÊÚÈ¨×¢²áÂë£¡</td>
              </tr>
              
              <tr>
                <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt2">51LAÍøÕ¾Í³¼ÆID£º</td>
                <td bgcolor="#f2f2f2">&nbsp;</td>
                <td height="30" bgcolor="#f2f2f2"><input name="tongj" type="text" id="tongj" size="15" /></td>
                <td height="30" bgcolor="#f2f2f2" class="left_txt">51laÍ³¼ÆID£¬»»³ÉÄúµÄÍ³¼ÆIDºÅ¼´¿É £¨<a href="http://www.51.la/reg.asp" target="_blank">Ãâ·Ñ×¢²á51laÍ³¼Æ</a>£©</td>
              </tr>
              <tr>
                <td height="30" align="right" class="left_txt2">ºóÌ¨¹ÜÀíÎÄ¼þ¼Ð£º</td>
                <td>&nbsp;</td>
                <td height="30"><input type="text" name="foxa" size="24" /></td>
                <td height="30" class="left_txt">¼ÓÇ¿°²È«ÐÔ£¬ÐÞ¸ÄºóÇë½«ºóÌ¨¹ÜÀíÎÄ¼þ¼Ð¸ÄÎª´ËÃû</td>
              </tr>
              <tr>
                <td height="17" colspan="4" align="right" >&nbsp;</td>
              </tr>
              <tr>
                <td height="30" colspan="4" align="right" class="left_txt2"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
                  <tr>
                    <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;»áÔ±ÀàÐÍ¼°ÊôÐÔ</td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="30" colspan="4" class="left_txt2"><table width="100%" height="99" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt">¢Ù
                      <input type="text"  name="aname" size="10" class="button01" />
                      »áÔ± </td>
                    <td width="20%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt">ÓÐÐ§ÆÚ£º
                      
                      Ìì</td>
                    <td width="60%" height="30" align="right" bgcolor="#f2f2f2" class="left_txt">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="30" align="right" class="left_txt">¢Ú
                      <input type="text"  name="bname" size="10" class="button01" />
                      »áÔ±</td>
                    <td height="30" align="right" class="left_txt">×ª»»ÂÊ£º</td>
                    <td height="30" align="right" class="left_txt">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt">¢Û
                      <input type="text" s name="cname" size="10" class="button01" />
                      »áÔ±</td>
                    <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt">ÓÐÐ§ÆÚ£º
                      <input type="text"  name="dqsjc" size="5" class="button01" />
                      <input type="text"  name="dqsja" size="5" class="button01" />
                      Ìì</td>
                    <td height="30" align="right" bgcolor="#f2f2f2" class="left_txt">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="16" colspan="3" align="right">&nbsp;</td>
                  </tr>
                  <tr>
                    <td colspan="3" align="right">&nbsp;</td>
                  </tr>
                  <tr>
                    <td colspan="3" align="right"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
                      <tr>
                        <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;Éè&nbsp; ÖÃ</td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="30" colspan="4" class="left_txt"><table width="100%" height="90" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="27%" align="center" bgcolor="#f2f2f2" class="left_txt">»áÔ±Éý»áÔ±Ðè£º</td>
                    <td width="27%" bgcolor="#f2f2f2" class="left_txt"><input type="text" style="color=red" name="asb" value="<%=%>" size="2" class="button01" /></td>
                    <td width="24%" bgcolor="#f2f2f2" class="left_txt">¡¡»áÔ±Éý»áÔ±Ðè</td>
                    <td width="22%" bgcolor="#f2f2f2" class="left_txt"><input type="text" style="color=red" name="bsc" value="<%=%>" size="2" class="button01" /></td>
                  </tr>
                  <tr>
                    <td align="center" class="left_txt">×¢²á»áÔ±ËÍ£º</td>
                    <td class="left_txt"><input type="text" style="color=red" name="dxb" value="<%=%>" size="2" class="button01" /></td>
                    <td class="left_txt">·¢²¼ÐÅÏ¢ÉÌÆ·ÏûºÄ£º</td>
                    <td class="left_txt"><input type="text" style="color=red" name="hxb" value="<%=%>" size="2" class="button01" />
                      /´Î</td>
                  </tr>
                  <tr>
                    <td align="center" bgcolor="#f2f2f2" class="left_txt">·¢²¼Í¼Æ¬ÐÅÏ¢Ðè£º</td>
                    <td bgcolor="#f2f2f2" class="left_txt"><input type="text" style="color=red" name="tdxb" value="<%=%>" size="2" class="button01" />
                      /´Î</td>
                    <td bgcolor="#f2f2f2" class="left_txt">ÉêÇëÍøÉÏµêÆÌÐè£º</td>
                    <td bgcolor="#f2f2f2" class="left_txt"><input type="text" style="color=red" name="ddxb" value="<%=%>" size="2" class="button01" /></td>
                  </tr>
                </table></td>
                </tr>
            </table></td>
          </tr>
        </table>
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td colspan="3"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="nowtable">
                <tr>
                  <td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;¹¦ÄÜ·Ö»ò×ª»»»òÏûºÄ</td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="30" colspan="3"><table width="100%" height="89" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="30" align="center" bgcolor="#f2f2f2" class="left_txt">»áÔ±µÇÂ½1´Î»ý£º
                    <input name="dlf" type="text" class="button01" id="dlf" style="color=red" value="<%=%>" size="2" />
·Ö</td>
                  <td height="30" bgcolor="#f2f2f2" class="left_txt">½éÉÜ1Î»»ý£º
                    <input name="jjf" type="text" class="button01" id="jjf" style="color=red" value="<%=%>" size="2" />
·Ö</td>
                  <td height="30" bgcolor="#f2f2f2" class="left_txt">»Ø¸´1´Î»ý£º
                    <input name="ddjf" type="text" class="button01" id="ddjf" style="color=red" value="<%=%>" size="2" />
·Ö</td>
                  <td height="30" bgcolor="#f2f2f2" class="left_txt">»ý·Ö
                    <input name="hjf" type="text" class="button01" id="hjf" style="color=red" value="<%=%>" size="2" />
¿É»»1</td>
                </tr>
                <tr>
                  <td height="30" align="center" class="left_txt">·¢²¼ÐÅÏ¢¹ã¸æ»ý£º
                    <input name="xxjf" type="text" class="button01" id="xxjf" style="color=red" value="<%=%>" size="2" />
·Ö</td>
                  <td height="30" class="left_txt">·¢²¼ÃûÆ¬»ý£º
                    <input name="mpjf" type="text" class="button01" id="mpjf" style="color=red" value="<%=%>" size="2" />
·Ö</td>
                  <td height="30" class="left_txt">¼ÓÈëÊÐ³¡ÁªÃË»ý£º
                    <input name="lmjf" type="text" class="button01" id="lmjf" style="color=red" value="<%=%>" size="2" />
·Ö</td>
                  <td height="30" class="left_txt">·¢²¼ÉÌÆ·»ý£º
                    <input name="spjf" type="text" class="button01" id="spjf" style="color=red" value="<%=%>" size="2" />
·Ö</td>
                </tr>
                <tr>
                  <td height="30" align="center" bgcolor="#f2f2f2" class="left_txt"><input name="gghjf" type="text" class="button01" id="gghjf" style="color=red" value="<%=%>" size="2" />
                    »»1ÖÃ¶¥¹¤¾ß</td>
                  <td height="30" bgcolor="#f2f2f2" class="left_txt">¸Ä×ÊÁÏ1´ÎºÄ£º
                    <input name="zlhjf" type="text" class="button01" id="zlhjf" style="color=red" value="<%=%>" size="2" />
·Ö</td>
                  <td height="30" bgcolor="#f2f2f2" class="left_txt">ÐÞ¸Ä·¢²¼ºÄ£º
                    <input name="xghjf" type="text" class="button01" id="xghjf" style="color=red" value="<%=%>" size="2" />
·Ö</td>
                  <td height="30" bgcolor="#f2f2f2" class="left_txt">ÉÏ´«ÈÏÖ¤½±£º
                    <input name="rzjf" type="text" class="button01" id="rzjf" style="color=red" value="<%=%>" size="2" />
·Ö</td>
                </tr>
              </table></td>
            </tr>
            
            <tr>
              <td height="30" colspan="3">&nbsp;</td>
            </tr>
            <tr>
              <td width="50%" height="30" align="right"><input type="submit" value="Íê³ÉÒÔÉÏÐÞ¸Ä" name="B1" /></td>
              <td width="6%" height="30" align="right">&nbsp;</td>
              <td width="44%" height="30"><input type="reset" value="È¡ÏûÉèÖÃ" name="B12" /></td>
            </tr>
            <tr>
              <td height="30" colspan="3">&nbsp;</td>
            </tr>
          </table></td>
      </tr>
    </table></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif"><img src="/kindergarten/pages/images/buttom_left2.gif" width="17" height="17" /></td>
      <td height="17" valign="top" background="images/buttom_bgs.gif"><img src="/kindergarten/pages/images/buttom_bgs.gif" width="17" height="17" /></td>
    <td background="images/mail_rightbg.gif"><img src="/kindergarten/pages/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>

</body>
