# How to run

First you need to compile it. To do this, open up the terminal and do:

```bash
gradle jar
```

This will make the compile everything to a jar file and put it in ```build/libs/PIDGimbalExtension-[version].jar```

If you are running Linux or mac, copy this file into ```~/.openrocket/Plugins/``` 

If you are running Windows, copy this file into ```C:\Users\[username]\AppData\Roaming\OpenRocket\Plugins\```

If you open OpenRocket and it should now work.



# How to run tests

```bash
gradle test
```

It shows almost nothing if all the tests pass.
