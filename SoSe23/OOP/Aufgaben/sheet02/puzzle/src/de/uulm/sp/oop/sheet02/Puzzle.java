package de.uulm.sp.oop.sheet02;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class Puzzle extends JPanel implements ActionListener, MouseListener {

    private static final String[] BUTTON_VALUES = {"^", "v", "<", ">"};
    private static final String[] BUTTON_ACTION_CMDS = {"N", "S", "W", "E"};
    private static final int[] BUTTON_ANCHORS = {GridBagConstraints.PAGE_START, GridBagConstraints.PAGE_END, GridBagConstraints.LINE_START, GridBagConstraints.LINE_END};
    private static final String[] BUTTON_ICONS_FILES = {"up.png", "down.png", "left.png", "right.png"};

    private JFrame frame;
    private BufferedImage img = null;

    int[][] pixels;

    private Timer timer = new Timer();

    public static void main(String[] args) {

        BufferedImage bfi = null;
        try {
            bfi = ImageIO.read(new File("img.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (bfi == null) {
            return;
        }

        Puzzle display = new Puzzle(bfi);
        display.start();
    }

    public Puzzle(BufferedImage bfi) {

        frame = new JFrame("");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pixels = new int[bfi.getHeight()][bfi.getWidth()];

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                pixels[i][j] = bfi.getRGB(j, i);
            }
        }

        this.setPreferredSize(new Dimension(400, 400));

        this.addMouseListener(this);

        frame.getContentPane().setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(Color.WHITE);


        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 1;
        c.weighty = 1;

        for (int pos = 0; pos < 4; pos++) {
            for (int i = 0; i < 5; i++) {
                JButton button = null;
                try {
                    ImageIcon icon = new ImageIcon(ImageIO.read(new File("arrows/" + BUTTON_ICONS_FILES[pos])));
                    ImageIcon scaledIcon = new ImageIcon(icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
                    button = new JButton(scaledIcon);
                } catch (IOException e) {
                    button = new JButton(BUTTON_VALUES[pos]);
                }

                button.setPreferredSize(new Dimension(80, 80));

                button.setActionCommand(String.format("%s-%d", BUTTON_ACTION_CMDS[pos], i));
                button.addActionListener(this);
                button.addMouseListener(this);
                c.anchor = BUTTON_ANCHORS[pos];

                if (pos < 2) {
                    c.gridx = i + 1;
                    c.gridy = pos == 0 ? 0 : 6;
                    c.fill = GridBagConstraints.HORIZONTAL;
                } else {
                    c.weighty = 1;
                    c.gridx = pos == 2 ? 0 : 6;
                    c.gridy = i + 1;
                    c.fill = GridBagConstraints.VERTICAL;
                }

                frame.getContentPane().add(button, c);
            }
        }

//        JButton save = new JButton("SAVE!");
//        save.setActionCommand("SAVE");
//        save.addActionListener(this);
//
//        c.anchor = GridBagConstraints.LAST_LINE_END;
//        c.gridx = 0;
//        c.gridy = 0;
//
//        c.gridwidth = 1;
//        c.gridheight = 1;
//        frame.getContentPane().add(save, c);

        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 5;
        c.gridheight = 5;
        frame.getContentPane().add(this, c);

        frame.pack();
        frame.setResizable(false);
    }

    public void start() {

        SwingUtilities.invokeLater(() -> frame.setVisible(true));

        touch();
    }

    private void touch() {
        img = matrixToImage();
        SwingUtilities.invokeLater(this::repaint);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img == null) {
            return;
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img.getScaledInstance(400, 400, Image.SCALE_SMOOTH), 0, 0, this);
        g2d.setColor(Color.RED);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String cmd = actionEvent.getActionCommand();

        if (actionEvent.getActionCommand().equals("SAVE")) {
            save();
            return;
        }

        int n = Integer.parseInt(cmd.split("-")[1]);

        for (int i = 0; i < 40; i++) {
            switch (cmd.split("-")[0]) {
                case "W":
                    PuzzleUtil.shiftRows(pixels, n * 40, (n + 1) * 40, true);
                    break;
                case "E":
                    PuzzleUtil.shiftRows(pixels, n * 40, (n + 1) * 40, false);
                    break;
                case "N":
                    PuzzleUtil.shiftCols(pixels, n * 40, (n + 1) * 40, false);
                    break;
                case "S":
                    PuzzleUtil.shiftCols(pixels, n * 40, (n + 1) * 40, true);
                    break;
            }
        }
        touch();
    }

    private void save() {

        try {
            ImageIO.write(img, "png", new File("out.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private BufferedImage matrixToImage() {

        BufferedImage img = new BufferedImage(pixels.length, pixels[0].length, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                img.setRGB(j, i, pixels[i][j]);
            }
        }

        return img;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if (mouseEvent.getSource() instanceof JPanel) {
            int rowi = mouseEvent.getY() / (this.getHeight() / 5);
            int coli = mouseEvent.getX() / (this.getWidth() / 5);
            PuzzleUtil.partialRotateClockwise(pixels, rowi * 40, (rowi + 1) * 40, coli * 40, (coli + 1) * 40);
            touch();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof JButton) {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    ((JButton) mouseEvent.getSource()).doClick();
                }
            }, 200, 200);
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

        timer.cancel();
        this.requestFocus();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}