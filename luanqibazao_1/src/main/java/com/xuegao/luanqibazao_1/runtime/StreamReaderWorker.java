package com.xuegao.luanqibazao_1.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class StreamReaderWorker implements StreamType, Callable<String> {

    private int type;
    private InputStream is;

    public StreamReaderWorker(InputStream is, int type) {
        this.is = is;
        this.type = type;
    }


    @Override
    public String call() throws Exception {
        if (is == null) return null;
        BufferedReader br = null;
        InputStreamReader isr = null;
        boolean isReadSth = false;
        try {
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String line = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = br.readLine()) != null) {
                isReadSth = true;
                stringBuffer.append(line);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (isr != null) isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }


}