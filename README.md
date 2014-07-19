vert.x-qrgen-module
===================

vert.x module to generate qrcode

Send an JSon message to "fr.tison.qrcode.generator"

```
{ "value" : "String to encode in QRcode" }
```

And the module will reply a Buffer containing a JPG with the corresponding QRcode.

*Thanks to https://github.com/kenglxn/QRGen library*