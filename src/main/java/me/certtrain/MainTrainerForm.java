
package me.certtrain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import static java.util.Optional.ofNullable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Riccardo
 */
public class MainTrainerForm extends javax.swing.JFrame {

	public static final ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

	/**
	 * Creates new form MainTrainerForm
	 */
	public MainTrainerForm() {
		Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> {
			JOptionPane.showMessageDialog(this, e.getClass()+" handled -> "+e.getMessage());
			e.printStackTrace();
		});
		
		initComponents();
		refreshDequePanel();
	}
	
	static void setLF(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	private void refreshDequePanel(){
		String[] jListContent = deque.stream().map(String::valueOf).collect(Collectors.toList()).toArray( new String[]{} );
		jListDeque.setListData( jListContent );
	}
	
	final List<Integer> RANDOM_POOL = IntStream.rangeClosed(0, 100).boxed().collect(Collectors.toList());
	
	private Integer getOrRandomizeInput(){
		if(isRandom()){
			var randomized = new ArrayList<Integer>(RANDOM_POOL);
			Collections.shuffle( randomized );
			inputT.setText( String.valueOf( randomized.get(0) ) );
		}
		return Integer.parseInt( inputT.getText() );
	}
	
	private void setOutput(String output){
		String out = ofNullable(output).orElse("");
		latestOutput.setText(out);
	}
	
	private boolean isRandom(){
		return randomCB.isSelected();
	}
	
	void insertTemplate(Function<Integer, ?> fxInsert){
		Object out = fxInsert.apply(getOrRandomizeInput());
		setOutput(out.toString());
		refreshDequePanel();
	}
	void insertTemplate(Consumer<Integer> fxGetRemove){
		fxGetRemove.accept(getOrRandomizeInput());
		refreshDequePanel();
	}
	void getOrRemoveTemplate(Supplier<?> fxGetRemove){
		Object out = fxGetRemove.get();
		setOutput(ofNullable(out).orElse("null").toString());
		refreshDequePanel();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListDeque = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        inputT = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        offerFirstB = new javax.swing.JButton();
        addFirstB = new javax.swing.JButton();
        getFirstB = new javax.swing.JButton();
        removeFirstB = new javax.swing.JButton();
        pollFirstB = new javax.swing.JButton();
        peekFirstB = new javax.swing.JButton();
        offerB = new javax.swing.JButton();
        addB = new javax.swing.JButton();
        getB = new javax.swing.JButton();
        removeB = new javax.swing.JButton();
        pollB = new javax.swing.JButton();
        peekB = new javax.swing.JButton();
        offerLastB = new javax.swing.JButton();
        addLastB = new javax.swing.JButton();
        getLastB = new javax.swing.JButton();
        removeLastB = new javax.swing.JButton();
        pollLastB = new javax.swing.JButton();
        peekLastB = new javax.swing.JButton();
        popB = new javax.swing.JButton();
        pushB = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        latestOutput = new javax.swing.JTextField();
        randomCB = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jListDeque.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1", "2" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListDeque);

        jLabel1.setText("DEQUE CONTENT");

        inputT.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        inputT.setToolTipText("");
        inputT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTActionPerformed(evt);
            }
        });

        jLabel2.setText("Next input");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Java Deque trainer");

        offerFirstB.setBackground(new java.awt.Color(0, 0, 102));
        offerFirstB.setText("offerFirst");
        offerFirstB.setToolTipText("");
        offerFirstB.setActionCommand("offerFirst");
        offerFirstB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offerFirstBActionPerformed(evt);
            }
        });

        addFirstB.setBackground(new java.awt.Color(0, 0, 102));
        addFirstB.setText("addFirst");
        addFirstB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFirstBActionPerformed(evt);
            }
        });

        getFirstB.setBackground(new java.awt.Color(0, 102, 0));
        getFirstB.setText("getFirst");
        getFirstB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getFirstBActionPerformed(evt);
            }
        });

        removeFirstB.setBackground(new java.awt.Color(204, 0, 51));
        removeFirstB.setText("removeFirst");
        removeFirstB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFirstBActionPerformed(evt);
            }
        });

        pollFirstB.setBackground(new java.awt.Color(204, 0, 51));
        pollFirstB.setText("pollFirst");
        pollFirstB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pollFirstBActionPerformed(evt);
            }
        });

        peekFirstB.setBackground(new java.awt.Color(0, 102, 0));
        peekFirstB.setText("peekFirst");
        peekFirstB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peekFirstBActionPerformed(evt);
            }
        });

        offerB.setBackground(new java.awt.Color(0, 0, 102));
        offerB.setText("offer");
        offerB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offerBActionPerformed(evt);
            }
        });

        addB.setBackground(new java.awt.Color(0, 0, 102));
        addB.setText("add");
        addB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBActionPerformed(evt);
            }
        });

        getB.setBackground(new java.awt.Color(0, 102, 0));
        getB.setText("get");
        getB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getBActionPerformed(evt);
            }
        });

        removeB.setBackground(new java.awt.Color(204, 0, 51));
        removeB.setText("remove");
        removeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBActionPerformed(evt);
            }
        });

        pollB.setBackground(new java.awt.Color(204, 0, 51));
        pollB.setText("poll");
        pollB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pollBActionPerformed(evt);
            }
        });

        peekB.setBackground(new java.awt.Color(0, 102, 0));
        peekB.setText("peek");
        peekB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peekBActionPerformed(evt);
            }
        });

        offerLastB.setBackground(new java.awt.Color(0, 0, 102));
        offerLastB.setText("offerLast");
        offerLastB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offerLastBActionPerformed(evt);
            }
        });

        addLastB.setBackground(new java.awt.Color(0, 0, 102));
        addLastB.setText("addLast");
        addLastB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLastBActionPerformed(evt);
            }
        });

        getLastB.setBackground(new java.awt.Color(0, 102, 0));
        getLastB.setText("getLast");
        getLastB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getLastBActionPerformed(evt);
            }
        });

        removeLastB.setBackground(new java.awt.Color(204, 0, 51));
        removeLastB.setText("removeLast");
        removeLastB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeLastBActionPerformed(evt);
            }
        });

        pollLastB.setBackground(new java.awt.Color(204, 0, 51));
        pollLastB.setText("pollLast");
        pollLastB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pollLastBActionPerformed(evt);
            }
        });

        peekLastB.setBackground(new java.awt.Color(0, 102, 0));
        peekLastB.setText("peekLast");
        peekLastB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peekLastBActionPerformed(evt);
            }
        });

        popB.setBackground(new java.awt.Color(204, 0, 51));
        popB.setText("pop");
        popB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popBActionPerformed(evt);
            }
        });

        pushB.setBackground(new java.awt.Color(0, 0, 102));
        pushB.setText("push");
        pushB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pushBActionPerformed(evt);
            }
        });

        jLabel4.setText("Latest output:");

        latestOutput.setEditable(false);

        randomCB.setText("Randomize");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(popB)
                                .addGap(18, 18, 18)
                                .addComponent(pushB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(offerFirstB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(addFirstB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(getFirstB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(removeFirstB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(pollFirstB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(peekFirstB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(offerB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(addB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(getB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(removeB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(pollB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(peekB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(offerLastB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(addLastB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(getLastB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(removeLastB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(pollLastB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(peekLastB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(latestOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(randomCB)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(inputT)
                                                        .addGap(16, 16, 16)))))
                                        .addGap(0, 60, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(randomCB))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addLastB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(offerLastB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getLastB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeLastB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pollLastB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(peekLastB))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(inputT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addFirstB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(offerFirstB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(getFirstB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeFirstB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pollFirstB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(peekFirstB))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(offerB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(getB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pollB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(peekB)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(popB)
                            .addComponent(pushB))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(latestOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTActionPerformed

    private void offerFirstBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offerFirstBActionPerformed
		insertTemplate(deque::offerFirst);
    }//GEN-LAST:event_offerFirstBActionPerformed

    private void addFirstBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFirstBActionPerformed
		insertTemplate(deque::addFirst);
    }//GEN-LAST:event_addFirstBActionPerformed

    private void getFirstBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getFirstBActionPerformed
        getOrRemoveTemplate(deque::getFirst);
    }//GEN-LAST:event_getFirstBActionPerformed

    private void removeFirstBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFirstBActionPerformed
        getOrRemoveTemplate(deque::removeFirst);
    }//GEN-LAST:event_removeFirstBActionPerformed

    private void pollFirstBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pollFirstBActionPerformed
        getOrRemoveTemplate(deque::pollFirst);
    }//GEN-LAST:event_pollFirstBActionPerformed

    private void peekFirstBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peekFirstBActionPerformed
        getOrRemoveTemplate(deque::peekFirst);
    }//GEN-LAST:event_peekFirstBActionPerformed

    private void offerBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offerBActionPerformed
		insertTemplate(deque::offer);
    }//GEN-LAST:event_offerBActionPerformed

    private void addBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBActionPerformed
        insertTemplate(deque::add);
    }//GEN-LAST:event_addBActionPerformed

    private void getBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getBActionPerformed
		throw new UnsupportedOperationException("There is no such get() in ArrayDeque");
    }//GEN-LAST:event_getBActionPerformed

    private void removeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBActionPerformed
        getOrRemoveTemplate(deque::remove);
    }//GEN-LAST:event_removeBActionPerformed

    private void pollBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pollBActionPerformed
        getOrRemoveTemplate(deque::poll);
    }//GEN-LAST:event_pollBActionPerformed

    private void peekBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peekBActionPerformed
        getOrRemoveTemplate(deque::peek);
    }//GEN-LAST:event_peekBActionPerformed

    private void offerLastBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offerLastBActionPerformed
		insertTemplate(deque::offerLast);
    }//GEN-LAST:event_offerLastBActionPerformed

    private void addLastBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLastBActionPerformed
        insertTemplate(deque::addLast);
    }//GEN-LAST:event_addLastBActionPerformed

    private void getLastBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getLastBActionPerformed
        getOrRemoveTemplate(deque::getLast);
    }//GEN-LAST:event_getLastBActionPerformed

    private void removeLastBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeLastBActionPerformed
        getOrRemoveTemplate(deque::removeLast);
    }//GEN-LAST:event_removeLastBActionPerformed

    private void pollLastBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pollLastBActionPerformed
        getOrRemoveTemplate(deque::pollLast);
    }//GEN-LAST:event_pollLastBActionPerformed

    private void peekLastBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peekLastBActionPerformed
        getOrRemoveTemplate(deque::peekLast);
    }//GEN-LAST:event_peekLastBActionPerformed

    private void popBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popBActionPerformed
        getOrRemoveTemplate(deque::pop);
    }//GEN-LAST:event_popBActionPerformed

    private void pushBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pushBActionPerformed
        insertTemplate(deque::push);
    }//GEN-LAST:event_pushBActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
//		try {
//			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//				if ("Nimbus".equals(info.getName())) {
//					javax.swing.UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}
//		} catch (ClassNotFoundException ex) {
//			java.util.logging.Logger.getLogger(MainTrainerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (InstantiationException ex) {
//			java.util.logging.Logger.getLogger(MainTrainerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (IllegalAccessException ex) {
//			java.util.logging.Logger.getLogger(MainTrainerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
//			java.util.logging.Logger.getLogger(MainTrainerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		}
		setLF();

		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainTrainerForm().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addB;
    private javax.swing.JButton addFirstB;
    private javax.swing.JButton addLastB;
    private javax.swing.JButton getB;
    private javax.swing.JButton getFirstB;
    private javax.swing.JButton getLastB;
    private javax.swing.JFormattedTextField inputT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jListDeque;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField latestOutput;
    private javax.swing.JButton offerB;
    private javax.swing.JButton offerFirstB;
    private javax.swing.JButton offerLastB;
    private javax.swing.JButton peekB;
    private javax.swing.JButton peekFirstB;
    private javax.swing.JButton peekLastB;
    private javax.swing.JButton pollB;
    private javax.swing.JButton pollFirstB;
    private javax.swing.JButton pollLastB;
    private javax.swing.JButton popB;
    private javax.swing.JButton pushB;
    private javax.swing.JCheckBox randomCB;
    private javax.swing.JButton removeB;
    private javax.swing.JButton removeFirstB;
    private javax.swing.JButton removeLastB;
    // End of variables declaration//GEN-END:variables
}
