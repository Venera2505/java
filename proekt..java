import java.util.*;
import java.util.stream.Collectors;

class Laptop {
    private String name;
    private String cpu;
    private int memory;
    private String gpu;
    private int ram;
    private String os;
    private String color;

    public Laptop(String name, String cpu, int memory, String gpu, int ram, String os, String color) {
        this.name = name;
        this.cpu = cpu;
        this.memory = memory;
        this.gpu = gpu;
        this.ram = ram;
        this.os = os;
        this.color = color;
    }

    // getters
    public String getName() { return name; }
    public String getCpu() { return cpu; }
    public int getMemory() { return memory; }
    public String getGpu() { return gpu; }
    public int getRam() { return ram; }
    public String getOs() { return os; }
    public String getColor() { return color; }

    @Override
    public String toString() {
        return "Ноутбук:\n" +
               "- Модель: " + name + "\n" +
               "- Процессор: " + cpu + "\n" +
               "- Объем памяти SSD/HDD: " + memory + " ГБ\n" +
               "- Видеокарта: " + gpu + "\n" +
               "- Объем оперативной памяти: " + ram + " ГБ\n" +
               "- Операционная система: " + os + "\n" +
               "- Цвет: " + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return memory == laptop.memory &&
               ram == laptop.ram &&
               name.equals(laptop.name) &&
               cpu.equals(laptop.cpu) &&
               gpu.equals(laptop.gpu) &&
               os.equals(laptop.os) &&
               color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cpu, memory, gpu, ram, os, color);
    }
}


public class Shop {
    public static void main(String[] args) {
        // Создаем новые модели ноутбуков
        Laptop laptop1 = new Laptop("HP Pavilion", "Intel Core i7", 1024, "NVIDIA GeForce GTX 1660 Ti",
                16, "Windows 10", "Silver");
        Laptop laptop2 = new Laptop("Dell XPS", "Intel Core i5", 512,
                "Intel Iris Xe Graphics", 8, "Ubuntu Linux", "Black");
        Laptop laptop3 = new Laptop("Apple MacBook Pro", "Apple M1 Pro", 512, "Apple 16-core GPU",
                16, "macOS Monterey", "Space Gray");
        Laptop laptop4 = new Laptop("Infinix Inbook X2", "Intel Core i9 13900HX", 2048, "RTX 4090",
                16, "Windows 11", "White");
        Laptop laptop5 = new Laptop("Dream Machines G1650-15RU72", "Intel Core i7 12800HX", 2048, "RTX 4080",
                32, "Windows 11", "Black");
        Laptop laptop6 = new Laptop("MSI Katana GF66", "AMD Ryzen 9 7945HX", 2048, "RTX 3080 Ti",
                32, "Windows 11", "White");
        Laptop laptop7 = new Laptop("ASUS TUF Gaming F15", "Intel Core i5 11400H", 1024, "RTX 3080",
                16, "Windows 11", "Black");
        Laptop laptop8 = new Laptop("Apple MacBook Air 13 2022", "Apple M2 Max 12 core 3680 MHz", 250, "Apple graphics 8-core",
                8, "macOS Monterey", "Pink");
        Laptop laptop9 = new Laptop("Acer Swift X", "AMD Ryzen 7 6800H", 1024, "RTX 2080 SUPER",
                16, "Windows 11", "White");
        Laptop laptop10 = new Laptop("Lenovo ThinkBook 15 G3ACL", "AMD Ryzen 5 5600HX", 512, "RX 6850M XT",
                8, "Windows 11", "Black");
        Laptop laptop11 = new Laptop("Dell G15", "Intel Core i7 12800HX", 1024, "RTX 4070",
                16, "Windows 11", "Pink");
        Laptop laptop12 = new Laptop("MSI GF66", "AMD Ryzen 9 7945HX", 2048, "RX 6800M",
                32, "Windows 11", "White");
        Laptop laptop13 = new Laptop("ASUS Vivobook Pro 15 OLED", "Intel Core i5 11400H", 512, "RTX 3080",
                8, "Windows 11", "Black");

        Set<Laptop> laptops = new HashSet<>(Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5, laptop6, laptop7, laptop8, laptop9, laptop10, laptop11, laptop12, laptop13));

        userRequest(laptops);
    }

    public static void userRequest(Set<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - Наименование");
        System.out.println("2 - Процессор");
        System.out.println("3 - Объем памяти SSD/HDD");
        System.out.println("4 - Видеокарта");
        System.out.println("5 - Объем оперативной памяти");
        System.out.println("6 - Операционная система");
        System.out.println("7 - Цвет");

        int criteria = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        Map<String, Object> filterCriteria = new HashMap<>();

        switch (criteria) {
            case 1:
                System.out.println("Введите желаемую модель ноутбука (доступные модели: " + getAllModels(laptops) + "):");
                String name = scanner.nextLine();
                filterCriteria.put("name", name);
                break;
            case 2:
                System.out.println("Введите желаемый процессор (доступные процессоры: " + getAllCpu(laptops) + "):");
                String cpu = scanner.nextLine();
                filterCriteria.put("cpu", cpu);
                break;
            case 3:
                System.out.println("Введите минимальный объем памяти SSD/HDD (доступные объемы: " + getAllMemory(laptops) + "):");
                int minMemory = scanner.nextInt();
                filterCriteria.put("memory", minMemory);
                break;
            case 4:
                System.out.println("Введите желаемую видеокарту (доступные видеокарты: " + getAllGpu(laptops) + "):");
                String gpu = scanner.nextLine();
                filterCriteria.put("gpu", gpu);
                break;
            case 5:
                System.out.println("Введите минимальный объем оперативной памяти (доступные объемы: " + getAllRam(laptops) + "):");
                int minRam = scanner.nextInt();
                filterCriteria.put("ram", minRam);
                break;
            case 6:
                System.out.println("Введите желаемую операционную систему (доступные системы: " + getAllOs(laptops) + "):");
                String os = scanner.nextLine();
                filterCriteria.put("os", os);
                break;
            case 7:
                System.out.println("Введите желаемый цвет (доступные цвета: " + getAllColor(laptops) + "):");
                String color = scanner.nextLine();
                filterCriteria.put("color", color);
                break;
            default:
                System.out.println("Некорректный выбор критерия.");
                return;
        }

        Set<Laptop> filteredLaptops = filterLaptops(laptops, filterCriteria);

        System.out.println("Отфильтрованные ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }

    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filterCriteria) {
        return laptops.stream()
                .filter(laptop -> filterCriteria.get("name") == null || laptop.getName().equals(filterCriteria.get("name")))
                .filter(laptop -> filterCriteria.get("cpu") == null || laptop.getCpu().equals(filterCriteria.get("cpu")))
                .filter(laptop -> filterCriteria.get("memory") == null || laptop.getMemory() >= (int) filterCriteria.get("memory"))
                .filter(laptop -> filterCriteria.get("gpu") == null || laptop.getGpu().equals(filterCriteria.get("gpu")))
                .filter(laptop -> filterCriteria.get("ram") == null || laptop.getRam() >= (int) filterCriteria.get("ram"))
                .filter(laptop -> filterCriteria.get("os") == null || laptop.getOs().equals(filterCriteria.get("os")))
                .filter(laptop -> filterCriteria.get("color") == null || laptop.getColor().equals(filterCriteria.get("color")))
                .collect(Collectors.toSet());
    }

    public static Set<String> getAllModels(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getName)
                .collect(Collectors.toSet());
    }

    public static Set<String> getAllCpu(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getCpu)
                .collect(Collectors.toSet());
    }

    public static Set<Integer> getAllMemory(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getMemory)
                .collect(Collectors.toSet());
    }

    public static Set<String> getAllGpu(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getGpu)
                .collect(Collectors.toSet());
    }

    public static Set<Integer> getAllRam(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getRam)
                .collect(Collectors.toSet());
    }

    public static Set<String> getAllOs(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getOs)
                .collect(Collectors.toSet());
    }

    public static Set<String> getAllColor(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::getColor)
                .collect(Collectors.toSet());
    }
}