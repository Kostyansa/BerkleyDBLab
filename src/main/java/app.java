import com.sleepycat.persist.EntityCursor;
import config.Database;
import entity.Region;
import entity.Server;
import repository.RegionDA;
import repository.ServerDA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class app {
    private static final Random random = new Random();

    public static void Lab3(){
        System.out.println("Начало теста третьей лабораторной");
        Database.setup();
        ServerDA ServerDA = new ServerDA(Database.getStore());
        RegionDA RegionDA = new RegionDA(Database.getStore());

        Region region = new Region(0, "Europe", "Anarchy");

        RegionDA.save(region);

        Server one = new Server(
                0,
                "Nebula",
                "localhost:5001",
                1
        );

        Server two = new Server(
                0,
                "Star Linked",
                "localhost:5002",
                1
        );

        Server three = new Server(
                0,
                "Galaxy One",
                "localhost:5003",
                1
        );

        ServerDA.save(one);
        ServerDA.save(two);
        ServerDA.save(three);

        List<Server> Servers = ServerDA.get();
        System.out.println("Сервера: ");
        System.out.println(Servers);

        System.out.println("Сервер с id = 2: ");
        System.out.println(ServerDA.get(2));


        System.out.println("Сервера региона с id = 1: ");
        System.out.println(ServerDA.getByRegionId(1));

        System.out.println(ServerDA.delete(2));
        one.setName("Glory");
        System.out.println(ServerDA.update(one));

        System.out.println("Сервера после удаления и обновления: ");
        System.out.println(ServerDA.get());
    }

    public static void Lab4() {

        Database.setup();
        ServerDA ServerDA = new ServerDA(Database.getStore());
        RegionDA RegionDA = new RegionDA(Database.getStore());

        Region region = new Region(0, "Europe", "Anarchy");
        RegionDA.save(region);
        region = new Region(0, "Asia", "Democracy");
        RegionDA.save(region);

        System.out.println("Регионы: ");
        System.out.println(RegionDA.get());

        for (int i = 0; i <= 4; i++){
            Server Server = new Server(
                    0,
                    "Nebula_" + i,
                    "localhost:500" + i,
                    random.nextInt(2) + 1
            );
            ServerDA.save(Server);
        }

        int target = 3;

        try (EntityCursor<Server> entityCursor = ServerDA.cursor()) {
            for (Server server: entityCursor){
                if (server.getId() == target)
                {
                    System.out.println("Найден сервер: ");
                    System.out.println(server);
                }
            }
        }

        target = 2;

        System.out.println("Сервера до обновления: ");
        System.out.println(ServerDA.get(target));

        try (EntityCursor<Server> entityCursor = ServerDA.cursor()) {
            for (Server server: entityCursor){
                if (server.getId() == 2)
                {
                    server.setRegion_id(((server.getRegion_id() - 1) % 2) + 1);
                    entityCursor.update(server);
                }
            }
        }

        System.out.println("Сервера после обновления: ");
        System.out.println(ServerDA.get(target));
    }

    public static void Lab5(){
        Database.setup();
        ServerDA ServerDA = new ServerDA(Database.getStore());
        RegionDA RegionDA = new RegionDA(Database.getStore());

        Region region = new Region(0, "Europe", "Anarchy");
        RegionDA.save(region);
        region = new Region(0, "Asia", "Democracy");
        RegionDA.save(region);

        System.out.println(RegionDA.get());

        for (int i = 0; i < 10; i++){
            Server Server = new Server(
                    0,
                    "Galaxy " + i,
                    "localhost:500" + i,
                    random.nextInt(2) + 1
            );
            ServerDA.save(Server);
        }
        for (int i = 0; i < 10; i++){
            Server Server = new Server(
                    0,
                    "Nebula " + i,
                    "localhost:500" + i,
                    random.nextInt(2) + 1
            );
            ServerDA.save(Server);
        }

        System.out.println("Сервера для региона 1: ");
        System.out.println(ServerDA.getByRegionId(1));
        System.out.println("Сервера Nebula для региона 1: ");
        System.out.println(ServerDA.getServersForRegionStartingWith(1, "Nebula"));
    }

    public static void main(String[] args) {
        Lab3();
        Lab4();
        Lab5();
    }
}
