package org.example.testovoe;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.Mutable;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.text.MutableAttributeSet;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TestApplication {
    @SneakyThrows
    public static void main(String[] args) {
////        SpringApplication.run(TestApplication.class, args);
//        var date = Date.from(Instant.now());
//        try {
//            GregorianCalendar calendar = new GregorianCalendar();
//            calendar.setTime(date);
//            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory
//                    .newInstance()
//                    .newXMLGregorianCalendarDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
//                            calendar.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
//
//            RemoteClientPifImport.Body.Buy buy  = new RemoteClientPifImport.Body.Buy();
//            buy.setApplicationDate(xmlGregorianCalendar);
//
//            RemoteClientPifImport.Body body = new RemoteClientPifImport.Body();
//            body.setBuy(buy);
//            var object = new RemoteClientPifImport();
//            object.setBody(body);
//
//
//
//            var xmlMapper = XmlMapper
//                    .xmlBuilder()
//                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//
//                    .serializationInclusion(JsonInclude.Include.NON_NULL)
//                    .enable(SerializationFeature.INDENT_OUTPUT)
//                    .defaultUseWrapper(false)
//                    .addModule(new JaxbAnnotationModule())
//                    .configure(ToXmlGenerator.Feature.WRITE_NULLS_AS_XSI_NIL, true)
//                    .build();
//
//            System.out.println(xmlMapper.writeValueAsString(object));
//
//            new Jaxb2Marshaller().createMarshaller().marshal(object,System.out);
//
//
//        } catch (DatatypeConfigurationException e) {
//
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println((LocalDate.now()));

//        List<Integer> as = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
//        List<Integer> as2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
//        List<Integer> as3 = new ArrayList<>(List.of(1, 2, 3, 4, 6));
//        List<List<Integer>> asn = new ArrayList<>(List.of(as, as2, as3));
//
//        var a = Stream.iterate(1, i -> i + 1).
//                limit(asn.stream().map(List::size).max(Integer::compare).orElse(0)).map(i -> "D" + i).
//                collect(Collectors.toList());
//        System.out.println(a);


//        String a3 = null;
//        String b3 = "213";

//        String a3 = "213";
//        String b3 = "213";

//        String a3 = "213";
//        String b3 = null;

//        String a3 = null;
//        String b3 = null;

//        if (a3 != null && b3 != null) {
//            System.out.println(StringUtils.join(a3, b3, " + "));
//        } else {
//            System.out.println(StringUtils.defaultString(a3) + StringUtils.defaultString(b3));
//        }
//        var file = new File("D:\\Книга1.csv");
//        var csvReader = new CSVReader(new FileReader(file));
//        List<CsvImport> csvToBeanBuilder =
//                new CsvToBeanBuilder<CsvImport>(new FileReader(file))
//                        .withSeparator(';').withType(CsvImport.class).build().parse();
//        System.out.println(csvToBeanBuilder.toString());
////
//        final Map<String, FormValue> formValueMap = new HashMap<>();
//
//        formValueMap.put("date", new FormValue(LocalDate.now(), "String"));
//        formValueMap.put("amount", new FormValue(BigDecimal.valueOf(1), "String"));
//        formValueMap.put("integer", new FormValue(10, "String"));
//
//        System.out.println(new ObjectMapper()
//                .registerModule(new JavaTimeModule())
//                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"))
//                .setTimeZone(TimeZone.getTimeZone("Europe/Moscow"))
//                .writeValueAsString(formValueMap));

//        System.out.println(LocalDate.parse("2020-04-01").datesUntil(LocalDate.parse("2022-06-24"))
//                .collect(Collectors.toList()));
        //
//    @Value
//    public static class FormValue {
//        @JsonFormat(shape = JsonFormat.Shape.STRING)
//        Object value;
//        String type;
//    }
//
//        Kryo kryo = new Kryo();
//
//        // нужно либо зарегистрировать все используемые классы,
//        kryo.register(Exception.class);
//
//        // либо указать, что мы доверяем источнику и можно инстанцировать
//        // любые классы
////        kryo.setRegistrationRequired(false);
////
////        Path path = Paths.get("vasya.dat");
////        try (Output output = new Output(Files.newOutputStream(path))) {
//            Exception person = new Exception("123");
//            kryo.writeObject(output, person);
//        }
//
//        try (Input input = new Input(Files.newInputStream(path))) {
//            Exception read = kryo.readObject(input, Exception.class);
//            System.out.printf("Read person: %s\n", read);
//        }

//        List<BigDecimal> items = new ArrayList<>();
//        items.add(BigDecimal.ONE);
//        items.add(BigDecimal.ONE);
//        items.add(BigDecimal.ONE);
//        items.add(BigDecimal.ONE);
//        items.add(BigDecimal.ONE);
//        items.add(BigDecimal.ONE);
//        items.add(BigDecimal.ONE);
//
////        System.out.println(items.stream().reduce(BigDecimal.valueOf(-7), BigDecimal::add));
//
//        Map<String, Integer> attrs =new HashMap<String, Integer>();
//
//        BigDecimal.valueOf()

//        Set<Integer> as = new HashSet<>();
//        as.add(null);
//        as.add(123);
//        as.stream().filter(integer -> integer.equals(123)).forEach(System.out::println);

//        System.out.println(!LocalDate.now().isAfter(LocalDate.now()));
//        StringUtils.isEmpty()
//        System.out.println(new BigDecimal(""));=
        var scanner = new Scanner(new FileInputStream("C:\\Users\\George\\Desktop\\deals (1) (3).txt"));
        scanner.nextLine();5
        System.out.println(scanner.nextLine());
    }
}


