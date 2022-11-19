# QR Code Generator

## Introduction

This application is intended to generate a QR Code by providing 2 input data:

1. the data (as string) that needs to be inserted inside the QR Code;
2. the output path that needs to be used to generate the QR Code image.

This program assumes to generate a QR Code (sized 5000x5000) with a high level of error correction.

Source: [JavatPoint](https://www.javatpoint.com/generating-qr-code-in-java).

### Requirements

You can find the requirements as it follows:

- Java (any version);
- Bash.

### Running

The program can be run as it follows:

```bash
# The first argument needs to be the data to insert in the QR Code, while the second one needs to be the output path in which the image will be stored
sh ./generate.sh "My Data" "$USER"/my_image.png
```

Make sure to explicit the image format in the path, otherwise you will get an error.