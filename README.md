# os-common-parse
parse csv、excel files 

1. Use Apache POI and easyexcel to analyze Excel files

2. Support parsing CSV files

3. Support parsing large excel 

### How to use it
```xml
<dependency>
   <groupId>com.github.shootercheng</groupId>
   <artifactId>common-parse</artifactId>
   <version>1.3</version>
</dependency>
```



Use code to create excel column to model field mapping, or use annotation form

#### Create params
##### code mapping
```java
        Map<String, String> fieldColumnMap = new HashMap<>(16);
        fieldColumnMap.put("A", "name");
        fieldColumnMap.put("B", "gender");
        fieldColumnMap.put("C", "num");
        Map<String, Method> columnMethodMap = FileParseCommonUtil.convertToColumnMethodMap(UserInfo.class, fieldColumnMap);
        ParseParam parseParam = new ParseParam().setStartLine(1)
                .setFieldSetterMap(columnMethodMap);
```
#### annotation
default sheet is 0
```java
    @Location(column = "A")
    private String name;
    @Location(column = "B")
    private String gender;
    @Location(column = "C")
    private String num;
```

If you need to parse multiple sheet pages
```java
    @Location(column = "A")
    private String string;
    @Location(column = "B")
    private String date;
    @Location(column = "C")
    private Double doubleData;
    @Location(column = "D")
    private Date utDate;
    @Location(sheet = 1, column = "A")
    private Integer id;
    @Location(sheet = 1, column = "B")
    private String userName;
    @Location(sheet = 1, column = "C")
    private Double score;
    @Location(sheet = 1, column = "D")
    private Date rdate;
```

#### Create parser

Three types of parsers are supported 

1. CsvFileParse
2. EasyExcelParse
3. ExcelFileParse

Different parsers are selected according to the parameters of different file types. If you have a parser of the same file type, you can specify

```java
FileParse fileParse = FileParseCreateor.createFileParse(FileParseCommonUtil.findParserType(filePath, parseParam));
```

Specify a parser

```java
parseParam.setParseType(ParseType.EASYEXCEL);
FileParse fileParse = FileParseCreateor.createFileParse(FileParseCommonUtil.findParserType(filePath, parseParam));
```

#### Parsing file
```java
List<ReflectVo> reflectVoList = fileParse.parseFile(filePath, ReflectVo.class, parseParam);
```

#### Example

[https://github.com/shootercheng/os-common-parse/blob/master/src/test/java/org/osource/scd/parse/ExcelParseAnno.java](https://github.com/shootercheng/os-common-parse/blob/master/src/test/java/org/osource/scd/parse/ExcelParseAnno.java)