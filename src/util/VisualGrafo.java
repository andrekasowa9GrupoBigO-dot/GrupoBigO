package util;

import modelo.Vertice;
import modelo.Aresta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;

public class VisualGrafo extends JPanel {

    private HashMap<String, Vertice> vertices;
    private List<Vertice> rotaDijkstra;


    public HashMap<String, Point> posicoes;


    private String verticeSelecionado = null;
    private final int RAIO = 15;

    public VisualGrafo(HashMap<String, Vertice> vertices, List<Vertice> rotaDijkstra) {
        this.vertices = vertices;
        this.rotaDijkstra = rotaDijkstra;
        posicoes = new HashMap<>();
        definirPosicoes();
        setPreferredSize(new Dimension(900, 700));

        ativarMovimento();
    }


    private void definirPosicoes() {
        posicoes.put("Cabinda", new Point(80, 80));
        posicoes.put("Zaire", new Point(150, 120));
        posicoes.put("Uíge", new Point(250, 140));
        posicoes.put("Bengo", new Point(200, 220));
        posicoes.put("Luanda", new Point(160, 260));
        posicoes.put("Cuanza Norte", new Point(300, 250));
        posicoes.put("Malanje", new Point(400, 200));
        posicoes.put("Lunda Norte", new Point(550, 180));
        posicoes.put("Lunda Sul", new Point(550, 260));
        posicoes.put("Moxico", new Point(700, 300));
        posicoes.put("Bié", new Point(420, 360));
        posicoes.put("Huambo", new Point(350, 420));
        posicoes.put("Cuanza Sul", new Point(300, 500));
        posicoes.put("Benguela", new Point(250, 580));
        posicoes.put("Huíla", new Point(400, 600));
        posicoes.put("Namibe", new Point(250, 650));
        posicoes.put("Cunene", new Point(450, 680));
        posicoes.put("Cuando Cubango", new Point(650, 550));

    }

    // ================= DESENHO =================
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        // Arestas
        for (Vertice v : vertices.values()) {
            Point p1 = posicoes.get(v.getNome());
            for (Aresta a : v.getArestas()) {
                Point p2 = posicoes.get(a.getDestino().getNome());

                if (rotaDijkstra != null && rotaContem(v, a.getDestino(), rotaDijkstra)) {
                    g2.setColor(Color.RED);
                } else {
                    g2.setColor(Color.GRAY);
                }
                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        // Vértices
        for (Vertice v : vertices.values()) {
            Point p = posicoes.get(v.getNome());
            g2.setColor(obterCorRegiao(v.getRegiao()));
            g2.fillOval(p.x - RAIO, p.y - RAIO, RAIO * 2, RAIO * 2);
            g2.setColor(Color.BLACK);
            g2.drawOval(p.x - RAIO, p.y - RAIO, RAIO * 2, RAIO * 2);
            g2.drawString(v.getNome(), p.x - RAIO, p.y - RAIO - 4);
        }
    }

    // ================= MOVIMENTO DOS VÉRTICES =================
    private void ativarMovimento() {
        MouseAdapter mouse = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                for (String nome : posicoes.keySet()) {
                    Point p = posicoes.get(nome);
                    if (p.distance(e.getPoint()) <= RAIO) {
                        verticeSelecionado = nome;
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                verticeSelecionado = null;
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (verticeSelecionado != null) {
                    posicoes.get(verticeSelecionado).setLocation(e.getPoint());
                    repaint();
                }
            }
        };

        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    private boolean rotaContem(Vertice v1, Vertice v2, List<Vertice> rota) {
        for (int i = 0; i < rota.size() - 1; i++) {
            if ((rota.get(i) == v1 && rota.get(i + 1) == v2) ||
                    (rota.get(i) == v2 && rota.get(i + 1) == v1)) {
                return true;
            }
        }
        return false;
    }

    private Color obterCorRegiao(String regiao) {
        switch (regiao) {
            case "Norte": return Color.RED;
            case "Sul": return Color.RED;
            case "Leste": return Color.RED;
            case "Oeste": return Color.RED;
            case "Centro": return Color.RED;
            case "Sul-Leste": return Color.RED;
            default: return Color.LIGHT_GRAY;
        }
    }


    public static void mostrarGrafo(HashMap<String, Vertice> vertices, List<Vertice> rota) {
        JFrame frame = new JFrame("Mapa de Angola - Rotas Nacionais");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new VisualGrafo(vertices, rota));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
