package io.manuelgozzi.pasticceriabentivoglio.qrcodegenerator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Manuel Gozzi
 */
public class Generator {

    public static void main(String[] args) throws IOException, WriterException {

        if (args.length != 2) {

            System.err.println(
                    "Invalid input provided. Make sure to pass the data as first argument, and the output path as the second argument"
            );
            System.exit(1);
        }

        //data that we want to store in the QR code
        String data = Objects.requireNonNull(args[0], "No data provided");
        String output = Objects.requireNonNull(args[1], "No path provided");

        System.out.printf(
                "Generating QR code with the following input:%n- data: %s%n- output path: %s%n",
                data,
                output
        );

        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        BitMatrix matrix = new MultiFormatWriter()
                .encode(
                        new String(data.getBytes(StandardCharsets.UTF_8)),
                        BarcodeFormat.QR_CODE,
                        5000,
                        5000,
                        hintMap
                );
        MatrixToImageWriter.writeToPath(
                matrix,
                output.substring(output.lastIndexOf('.') + 1),
                Paths.get(output)
        );

        //prints if the QR code is generated
        System.out.println("QR Code created successfully!");
    }
}
