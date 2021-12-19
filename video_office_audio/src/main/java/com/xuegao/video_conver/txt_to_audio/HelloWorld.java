// package com.xuegao.video_conver.txt_to_audio;
//
// import javax.sound.midi.Synthesizer;
// import java.util.Locale;
//
// public class HelloWorld {
//     public static void main(String args[]) {
//         try {
//             // Create a synthesizer for English
//             Synthesizer synth = Central.createSynthesizer(
//                     new SynthesizerModeDesc(Locale.ENGLISH));
//
//             // Get it ready to speak
//             synth.allocate();
//             synth.resume();
//
//             // Speak the "Hello world" string
//             synth.speakPlainText("Hello, world!", null);
//
//             // Wait till speaking is done
//             synth.waitEngineState(Synthesizer.QUEUE_EMPTY);
//
//             // Clean up
//             synth.deallocate();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }