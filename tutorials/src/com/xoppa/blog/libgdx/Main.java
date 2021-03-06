/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.xoppa.blog.libgdx;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeSelectionModel;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main extends JFrame {
	public static String data;
	
	public static class AppDesc {
		public Class<? extends ApplicationListener> clazz;
		public String title;
		public boolean useGL20;
		public int width;
		public int height;
		public String data;
		
		public AppDesc(String title, boolean useGL20, int width, int height, Class<? extends ApplicationListener> clazz, String data) {
			this.clazz = clazz;
			this.title = title;
			this.useGL20 = useGL20;
			this.width = width;
			this.height = height;
			this.data = data;
		}
		
		public AppDesc(String title, boolean useGL20, int width, int height, Class<? extends ApplicationListener> clazz) {
			this(title, useGL20, width, height, clazz, null);
		}
		
		@Override
		public String toString() {
			return title;
		}
	}
	
	public final static Object[] apps = {
		"Tutorials",
		new Object[] {
				"Basic 3D using libgdx",
				new AppDesc("step 1: render a cube", false, 640, 480, com.xoppa.blog.libgdx.g3d.basic3d.step1.Basic3DTest.class),
				new AppDesc("step 2: lights", false, 640, 480, com.xoppa.blog.libgdx.g3d.basic3d.step2.Basic3DTest.class),
				new AppDesc("step 3: camera controller", false, 640, 480, com.xoppa.blog.libgdx.g3d.basic3d.step3.Basic3DTest.class)			
		},
		new Object[] {
				"Load models using libgdx",
				new AppDesc("step 1: load a wavefrom model", false, 640, 480, com.xoppa.blog.libgdx.g3d.loadmodels.step1.LoadModelsTest.class, "loadmodels/data"),
				new AppDesc("step 2: use assetmanager", false, 640, 480, com.xoppa.blog.libgdx.g3d.loadmodels.step2.LoadModelsTest.class, "loadmodels/data"),
				new AppDesc("step 3: multiple instances", false, 640, 480, com.xoppa.blog.libgdx.g3d.loadmodels.step3.LoadModelsTest.class, "loadmodels/data"),
				new AppDesc("step 4: use fbx-conv", false, 640, 480, com.xoppa.blog.libgdx.g3d.loadmodels.step4.LoadModelsTest.class, "loadmodels/data")
		},
		new Object[] {
				"Loading a scene using libgdx",
				new AppDesc("step 1: coding a scene", false, 640, 480, com.xoppa.blog.libgdx.g3d.loadscene.step1.LoadSceneTest.class, "loadscene/data"),
				new AppDesc("step 2: combining models", false, 640, 480, com.xoppa.blog.libgdx.g3d.loadscene.step2.LoadSceneTest.class, "loadscene/data"),
				new AppDesc("step 3: loading a modeled scene", false, 640, 480, com.xoppa.blog.libgdx.g3d.loadscene.step3.LoadSceneTest.class, "loadscene/data")
		},
		new Object[] {
				"Behind the 3D scenes",
				new AppDesc("step 1: base code", false, 640, 480, com.xoppa.blog.libgdx.g3d.behindscenes.step1.BehindTheScenesTest.class, "behindscenes/data"),
				new AppDesc("step 2: using ModelLoader", false, 640, 480, com.xoppa.blog.libgdx.g3d.behindscenes.step2.BehindTheScenesTest.class, "behindscenes/data"),
				new AppDesc("step 3: change material by NodePart", false, 640, 480, com.xoppa.blog.libgdx.g3d.behindscenes.step3.BehindTheScenesTest.class, "behindscenes/data"),
				new AppDesc("step 4: change material by name", false, 640, 480, com.xoppa.blog.libgdx.g3d.behindscenes.step4.BehindTheScenesTest.class, "behindscenes/data"),
				new AppDesc("step 5: change material per ModelInstance", false, 640, 480, com.xoppa.blog.libgdx.g3d.behindscenes.step5.BehindTheScenesTest.class, "behindscenes/data"),
				new AppDesc("step 6: using a Renderable", false, 640, 480, com.xoppa.blog.libgdx.g3d.behindscenes.step6.BehindTheScenesTest.class, "behindscenes/data"),
				new AppDesc("step 7: using a Shader", true, 640, 480, com.xoppa.blog.libgdx.g3d.behindscenes.step7.BehindTheScenesTest.class, "behindscenes/data")
		},
		new Object[] {
				"Creating a shader with libgdx",
				new AppDesc("step 1: render a sphere", true, 640, 480, com.xoppa.blog.libgdx.g3d.createshader.step1.ShaderTest.class, "createshader/data"),
				new AppDesc("step 2: render points", true, 640, 480, com.xoppa.blog.libgdx.g3d.createshader.step2.ShaderTest.class, "createshader/data"),
				new AppDesc("step 3: customize default shader", true, 640, 480, com.xoppa.blog.libgdx.g3d.createshader.step3.ShaderTest.class, "createshader/data"),
				new AppDesc("step 4: implement shader", true, 640, 480, com.xoppa.blog.libgdx.g3d.createshader.step4.ShaderTest.class, "createshader/data"),
				new AppDesc("step 5: enable depth test", true, 640, 480, com.xoppa.blog.libgdx.g3d.createshader.step5.ShaderTest.class, "createshader/data"),
				new AppDesc("step 6: cache uniform locations", true, 640, 480, com.xoppa.blog.libgdx.g3d.createshader.step6.ShaderTest.class, "createshader/data")
		},
		new Object[] {
				"Using materials with libgdx",
				new AppDesc("step 1: using modelbatch", true, 640, 480, com.xoppa.blog.libgdx.g3d.usingmaterials.step1.MaterialTest.class, "usingmaterials/data"),
				new AppDesc("step 2: add a uniform", true, 640, 480, com.xoppa.blog.libgdx.g3d.usingmaterials.step2.MaterialTest.class, "usingmaterials/data"),
				new AppDesc("step 3: using userData", true, 640, 480, com.xoppa.blog.libgdx.g3d.usingmaterials.step3.MaterialTest.class, "usingmaterials/data"),
				new AppDesc("step 4: using ColorAttribute", true, 640, 480, com.xoppa.blog.libgdx.g3d.usingmaterials.step4.MaterialTest.class, "usingmaterials/data"),
				new AppDesc("step 5: implement canRender", true, 640, 480, com.xoppa.blog.libgdx.g3d.usingmaterials.step5.MaterialTest.class, "usingmaterials/data"),
				new AppDesc("step 6: add another color", true, 640, 480, com.xoppa.blog.libgdx.g3d.usingmaterials.step6.MaterialTest.class, "usingmaterials/data"),
				new AppDesc("step 7: use custom attribute", true, 640, 480, com.xoppa.blog.libgdx.g3d.usingmaterials.step7.MaterialTest.class, "usingmaterials/data"),
				new AppDesc("step 8: update canRender", true, 640, 480, com.xoppa.blog.libgdx.g3d.usingmaterials.step8.MaterialTest.class, "usingmaterials/data"),
				new AppDesc("step 8: create custom attribute", true, 640, 480, com.xoppa.blog.libgdx.g3d.usingmaterials.step9.MaterialTest.class, "usingmaterials/data")
		}
	};
	
	public static boolean runApp(final AppDesc appDesc) {
		ApplicationListener listener;
		try {
			listener = appDesc.clazz.newInstance();
		} catch (InstantiationException e) {
			return false;
		} catch (IllegalAccessException e) {
			return false;
		}
		data = (appDesc.data == null || appDesc.data.isEmpty()) ? "data" : appDesc.data; 
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = appDesc.width;
		config.height = appDesc.height;
		config.title = appDesc.title;
		config.useGL20 = appDesc.useGL20;
		config.forceExit = false;
		new LwjglApplication(listener, config);
		return true;
	}
	
	public static void main(String[] args) throws Throwable {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new Main();
	}
	
	public Main() throws HeadlessException {
		super("Xoppa Libgdx Tutorials");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new AppList());
		pack();
		setSize(250, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	class AppList extends JPanel {
		public AppList () {
			setLayout(new BorderLayout());

			final JButton button = new JButton("Run Test");

			DefaultMutableTreeNode root = processHierarchy(apps);
			final JTree tree = new JTree(root);
			JScrollPane pane = new JScrollPane(tree);

			DefaultTreeSelectionModel m = new DefaultTreeSelectionModel();
			m.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			tree.setSelectionModel(m);

			tree.addMouseListener(new MouseAdapter() {
				public void mouseClicked (MouseEvent event) {
					if (event.getClickCount() == 2) button.doClick();
				}
			});

			tree.addKeyListener(new KeyAdapter() {
				public void keyPressed (KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) button.doClick();
				}
			});

			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed (ActionEvent e) {
					Object obj = ((DefaultMutableTreeNode)tree.getLastSelectedPathComponent()).getUserObject();
					if (obj instanceof AppDesc) {
						AppDesc app = (AppDesc)obj;
						dispose();
						runApp(app);
					}
				}
			});

			add(pane, BorderLayout.CENTER);
			add(button, BorderLayout.SOUTH);
		}
		
		private DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(hierarchy[0]);
			DefaultMutableTreeNode child;
			for(int i=1; i<hierarchy.length; i++) {
				Object nodeSpecifier = hierarchy[i];
				if (nodeSpecifier instanceof Object[])
					child = processHierarchy((Object[])nodeSpecifier);
				else
					child = new DefaultMutableTreeNode(nodeSpecifier);
				node.add(child);
			}
			return node;
		}
	}
}
