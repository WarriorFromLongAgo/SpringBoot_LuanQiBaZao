package com.xuegao.luanqibazao_1.ali.fastjson.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

// customerid customercode
public class JsonObjectTest {
    public static void main(String[] args) {
        String json = "[\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"132479\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02125721989\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"979173\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"51067937511\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"1112374\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02152970732\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"1618040\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02162731161\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"2453868\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02119802272\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"2706798\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"057106686689\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3211800\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02110122277\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3377347\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02160065558\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3519535\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"035493569119\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3870983\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"056223811599\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3878315\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02187093956\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3940341\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"076016266638\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"4001039\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02119681668\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"4266021\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02196523199\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"270087\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"051267186828\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"644234\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02131683541\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"997461\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02103636603\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"1603590\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"051261280506\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"1874965\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02129097688\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"2269404\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02146763473\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"2320281\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02123032942\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"2513234\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"073110665685\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3069481\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02123639353\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3105591\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02163667735\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3377347\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02160065558\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3409855\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02193672025\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"4169275\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02196661769\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"4522673\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02157362905\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"573384\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02142406\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"1405588\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"76922036737\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"1826543\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02158356677\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"2710687\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"051906766009\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"2882616\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02188663366\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"2900160\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02139986763\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3153911\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02130622296\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3194463\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"057973986630\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3468306\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"051250736606\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3618562\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"075762356726\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3639840\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02106012886\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3681217\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02176736258\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"4138143\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02159820719\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"4169275\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02196661769\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"4330485\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"037668859376\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"461837\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02192175138\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"487953\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02168279669\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"1355046\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"031625720161\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"1405588\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"76922036737\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"2196822\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02182700902\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"2237534\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02122787560\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"2796069\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"075553906790\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3179727\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02127066561\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3340372\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"075296933012\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3395684\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02151361952\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3540659\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02166677015\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3746957\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"051207359919\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3780177\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02181993599\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"4056117\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02138033623\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"147473\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"51296778388\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"694545\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02154671893\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"1405588\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"76922036737\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"1911234\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02118272076\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3234382\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02135373668\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3289097\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"051208659325\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3377347\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"02160065558\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3632070\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"057931372526\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3652811\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"01068237355\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"3713435\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"051227982623\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": {\n" +
                "          \"cellValue\": \"4023265\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        },\n" +
                "        \"customer_code\": {\n" +
                "          \"cellValue\": \"051018021098\",\n" +
                "          \"encryptFlag\": 0\n" +
                "        }\n" +
                "      }\n" +
                "    ]";
        JSONArray jsonArray = JSONObject.parseArray(json);
        System.out.println(jsonArray.size());
        List<String> customerIdList = new ArrayList<>();
        List<String> customerCodeList = new ArrayList<>();
        JSONObject customerIdCustomerCode = new JSONObject();
        for (Object o : jsonArray) {
            JSONObject jsonObject = JSONObject.parseObject(o.toString());
            System.out.println(jsonObject);
            JSONObject idJsonObject = jsonObject.getJSONObject("id");
            JSONObject customerCodeJsonObject = jsonObject.getJSONObject("customer_code");
            String customerId = idJsonObject.getString("cellValue");
            String customerCode = customerCodeJsonObject.getString("cellValue");


            customerIdCustomerCode.put(customerId, customerCode);
        }


        String str = "2453868,3377347,4001039,3211800,2706798,132479,3878315,3519535,3870983,4266021,1112374,1618040,3940341,3377347,979173,3409855,997461,270087,3377347,1874965,644234,2320281,2269404,4169275,2513234,4522673,3069481,1603590,3105591,3105591,1826543,3681217,3639840,3468306,3194463,4138143,3618562,573384,2882616,1405588,3153911,2900160,2710687,4169275,4330485,1355046,1405588,2237534,3746957,3340372,487953,4056117,3179727,2796069,1405588,3780177,2196822,3395684,3540659,461837,3652811,1405588,3632070,4023265,147473,3289097,1911234,1911234,694545,1405588,3713435,3377347,3234382";
        for (String customerId : str.split(",")) {
            String customerCode = customerIdCustomerCode.getString(customerId);
            customerIdList.add(customerId);
            customerCodeList.add(customerCode);
        }

        for (String s : customerIdList) {
            System.out.println(s);
        }
        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("==================================");
        for (String s : customerCodeList) {
            System.out.println(s);
        }

    }
}
