package repository;

import model.Terminal;
import model.Zone;
import java.util.ArrayList;
import java.util.List;

public class TerminalRepository extends AbstractRepository<Terminal> {

    private static TerminalRepository terminalRepository;

    private TerminalRepository() {
        create(new Terminal(new Zone("Pilar", 5), "Terminal en Pilar"));
        create(new Terminal(new Zone("San Isidro", 10), "Terminal en San Isidro"));
        create(new Terminal(new Zone("Vicente Lopez", 15), "Terminal en Vicente Lopez"));
        create(new Terminal(new Zone("Villa Crespo", 20), "Terminal en Villa Crespo"));
        create(new Terminal(new Zone("Munro", 5), "Terminal en Munro"));
        create(new Terminal(new Zone("Tigre", 10), "Terminal en Tigre"));
        create(new Terminal(new Zone("Pacheco", 15), "Terminal en Pacheco"));
        create(new Terminal(new Zone("Pilar", 20), "Terminal en Pilar"));
        create(new Terminal(new Zone("CABA", 5), "Terminal en CABA"));
        create(new Terminal(new Zone("La Lucila", 10), "Terminal en La Lucila"));
    }

    public List<Terminal> searchByZone(Zone zone) {
        List<Terminal> terminals = findAll();
        List<Terminal> terminalsInZone = new ArrayList<>();

        for (Terminal terminal: terminals) {
            if (terminal.showZone().equals(zone)) {
                terminalsInZone.add(terminal);
            }
        }

        return terminalsInZone;
    }

    public Terminal searchOneByZone(Zone zone) {
        List<Terminal> terminals = findAll();

        for (Terminal terminal: terminals) {
            if (terminal.showZone().equals(zone)) return terminal;
        }

        return null;
    }

    public static TerminalRepository getInstance() {
        if (terminalRepository != null) {
            return terminalRepository;
        } else {
            terminalRepository = new TerminalRepository();
        }

        return terminalRepository;
    }
}
