package LexicalAnalyzier;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.DefaultEditorKit.DefaultKeyTypedAction;
import javax.swing.tree.DefaultMutableTreeNode;

import Nodes.Array;
import Nodes.Array1;
import Nodes.Array2;
import Nodes.BooleanType;
import Nodes.CharType;
import Nodes.ClassDeclaration;
import Nodes.ClassDeclarationSTM;
import Nodes.ClassDeclarationSTM1;
import Nodes.ClassDeclarationSTM2;
import Nodes.Constructor_;
import Nodes.Constructor_1;
import Nodes.Constructor_2;
import Nodes.Else;
import Nodes.ElseInterface;
import Nodes.Expression;
import Nodes.Expression1;
import Nodes.Expression1Fn;
import Nodes.Expression1Fn1;
import Nodes.Expression1Fn2;
import Nodes.Expression2;
import Nodes.Expression3;
import Nodes.Expression4;
import Nodes.Expression5;
import Nodes.Expression6;
import Nodes.Expression7;
import Nodes.Expression8;
import Nodes.ExpressionRec;
import Nodes.ExpressionRec1;
import Nodes.ExpressionRec2;
import Nodes.ExpressionRec3;
import Nodes.ExpressionRec4;
import Nodes.ExpressionSTM;
import Nodes.ExpressionSTM1;
import Nodes.ExpressionSTM2;
import Nodes.ExpressionSTM_;
import Nodes.ExpressionSTM_1;
import Nodes.ExpressionSTM_2;
import Nodes.Extends;
import Nodes.Extends1;
import Nodes.Extends2;
import Nodes.FloatType;
import Nodes.Goal;
import Nodes.INTEGRAL_LITERAL;
import Nodes.Identifier;
import Nodes.IdentifierAssign;
import Nodes.IdentifierAssign1;
import Nodes.IdentifierAssign2;
import Nodes.IntType;
import Nodes.MainClass;
import Nodes.MethodDeclaration;
import Nodes.MethodDeclarationSTM;
import Nodes.MethodDeclarationSTM1;
import Nodes.MethodDeclarationSTM2;
import Nodes.Operator;
import Nodes.Operator1;
import Nodes.Operator2;
import Nodes.Operator3;
import Nodes.Operator4;
import Nodes.Operator5;
import Nodes.Operator6;
import Nodes.Paramerter;
import Nodes.Paramerter1;
import Nodes.Paramerter2;
import Nodes.ParamerterSTM;
import Nodes.ParamerterSTM1;
import Nodes.ParamerterSTM2;
import Nodes.Private;
import Nodes.Public;
import Nodes.Statement1;
import Nodes.Statement2;
import Nodes.Statement3;
import Nodes.Statement4;
import Nodes.Statement5;
import Nodes.StatementSTM;
import Nodes.StatementSTM1;
import Nodes.StatementSTM2;
import Nodes.Statment;
import Nodes.StringType;
import Nodes.Terminal;
import Nodes.Type;
import Nodes.VarDeclaration;
import Nodes.VarDeclarationSTM;
import Nodes.VarDeclarationSTM1;
import Nodes.VarDeclarationSTM2;
import Nodes.Visiblity;
import Nodes.notElse;

public class Parser {

	Queue<Token> queue;
	DefaultMutableTreeNode root;

	public Parser(ArrayList<Token> tokens) {
		queue = new LinkedList<>();
		SetQueue(tokens);
	}

	public DefaultMutableTreeNode getRoot() {
		return root;
	}

	private void SetQueue(ArrayList<Token> tokens) {
		for (Token token : tokens) {
			if (!token.getType().equals("Space") && !token.getType().equals("EOL"))
				queue.add(token);
		}
	}

	// <MainClass> <CalssDeclationSTM> <EOF>
	public Goal goal() {
		root = new DefaultMutableTreeNode("Goal");

		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("MainClass");
		root.add(node1);

		MainClass m = mainClass(node1);

		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("ClassDeclration");
		root.add(node2);

		ClassDeclarationSTM c = classDeclarationSTM(node2);

		if (m != null && queue.isEmpty() && c != null)
			return new Goal(m, c);

		return null;
	}

	// <MainClass> -> "class" <Identifier> "{" "public" "static" "void" "main"
	// "(" "String" "[" "]" <Identifier> ")" "{" <Statement> "}" "}"
	private MainClass mainClass(DefaultMutableTreeNode nodeName) {

		DefaultMutableTreeNode node;

		Token token = queue.peek();
		if (!token.getValue().equals(Terminal.CLASS)) {
			System.out.println("expected 'class' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		Token token1 = queue.peek();
		if (!token1.getType().equals(Terminal.Identifier)) {
			System.out.println("expected 'ID' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token1.getValue());
		nodeName.add(node);
		queue.poll();

		token = queue.peek();
		if (!token.getValue().equals(Terminal.LEFT_CURLY_B)) {
			System.out.println("expected '{' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		token = queue.peek();

		if (!token.getValue().equals(Terminal.PUBLIC)) {
			System.out.println("expected 'public' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		token = queue.peek();
		if (!token.getValue().equals(Terminal.STATIC)) {
			System.out.println("expected 'static' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);
		queue.poll();

		token = queue.peek();
		if (!token.getValue().equals(Terminal.VOID)) {
			System.out.println("expected 'void' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();
		token = queue.peek();
		if (!token.getValue().equals(Terminal.MAIN)) {
			System.out.println("expected 'main' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		token = queue.peek();
		if (!token.getValue().equals(Terminal.LEFT_ROUND_B)) {
			System.out.println("expected '(' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		token = queue.peek();
		if (!token.getValue().equals(Terminal.STRING)) {
			System.out.println("expected 'string' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		token = queue.peek();
		if (!token.getValue().equals(Terminal.LEFT_SQUARE_B)) {
			System.out.println("expected '[' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		token = queue.peek();
		if (!token.getValue().equals(Terminal.RIGHT_SQUARE_B)) {
			System.out.println("expected ']' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		Token token2 = queue.peek();
		if (!token2.getType().equals(Terminal.Identifier)) {
			System.out.println("expected 'ID' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token2.getValue());
		nodeName.add(node);

		queue.poll();

		token = queue.peek();
		if (!token.getValue().equals(Terminal.RIGHT_ROUND_B)) {
			System.out.println("expected ')' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		token = queue.peek();
		if (!token.getValue().equals(Terminal.LEFT_CURLY_B)) {
			System.out.println("expected '{' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		node = new DefaultMutableTreeNode("Statment");
		nodeName.add(node);

		Statment stm = statment(node);
		if (stm == null) {
			System.out.println("Statment return NULL  in MainClass Function");
			return null;
		}

		token = queue.peek();
		if (!token.getValue().equals(Terminal.RIGHT_CURLY_B)) {
			System.out.println("expected '}' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		token = queue.peek();
		if (!token.getValue().equals(Terminal.RIGHT_CURLY_B)) {
			System.out.println("expected '}' in main class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		return new MainClass(new Identifier(token1.getValue()), new Identifier(token2.getValue()), stm);

	}

	// "class" <Identifier> <extends> "{" <VarDeclarationSTM>
	// <MethodDeclarationSTM> "}"
	private ClassDeclaration classDeclation(DefaultMutableTreeNode nodeName) {

		DefaultMutableTreeNode node;

		Token token = queue.peek();
		if (!token.getValue().equals(Terminal.CLASS)) {
			System.out.println("expected 'class' in class declaration class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		token = queue.peek();
		if (!token.getType().equals(Terminal.Identifier)) {
			System.out.println("expected 'ID' in class declaration class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();
		Identifier id1 = new Identifier(token.getValue());

		node = new DefaultMutableTreeNode("Extends");
		nodeName.add(node);

		Extends ex = extend(node);
		if (ex == null)
			return null;

		token = queue.peek();
		if (!token.getValue().equals(Terminal.LEFT_CURLY_B)) {
			System.out.println("expected '{' in class declaration class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		node = new DefaultMutableTreeNode("VarDeclarationStatment");
		nodeName.add(node);

		VarDeclarationSTM var = varDeclarationSTM(node);
		if (var == null)
			return null;

		node = new DefaultMutableTreeNode("MethodDeclarationStatement");
		nodeName.add(node);

		MethodDeclarationSTM method = methodDeclarationSTM(node);
		if (method == null)
			return null;

		token = queue.peek();
		if (!token.getValue().equals(Terminal.RIGHT_CURLY_B)) {
			System.out.println("expected '}' in class declaration class");
			return null;
		}
		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		return new ClassDeclaration(id1, ex, var, method);

	}

	// <ClassDeclarationSTM> -> <ClassDeclaration> <ClassDeclarationSTM> | $
	private ClassDeclarationSTM classDeclarationSTM(DefaultMutableTreeNode nodeName) {

		DefaultMutableTreeNode node;

		Token token = queue.peek();
		if ((token == null) || (!token.getValue().equals(Terminal.CLASS))) {
			return new ClassDeclarationSTM2();
		}

		node = new DefaultMutableTreeNode("ClassDeclaration");
		nodeName.add(node);
		ClassDeclaration cl = classDeclation(node);
		if (cl == null)
			return null;

		node = new DefaultMutableTreeNode("ClassDeclarationSTM");
		nodeName.add(node);

		return new ClassDeclarationSTM1(cl, classDeclarationSTM(node));
	}

	private Extends extend(DefaultMutableTreeNode nodeName) {
		Token token = queue.peek();
		if (!token.getValue().equals(Terminal.EXTENDS)) {
			return new Extends2();
		}

		queue.poll();
		token = queue.peek();

		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Extend  " + token.getValue());
		nodeName.add(node);
		queue.poll();
		return new Extends1(new Identifier(token.getValue()));
	}

	/*
	 * <Statement> -> "{" <StatementSTM> "}" | "if" "("
	 * <Expression>")"<Statement> <Else> |"while" "(" <Expression> ")"
	 * <Statement> |"System.out.println" "(" <Expression> ")" ";"
	 * |<Identifier><IdentifierAssign>
	 */
	private Statment statment(DefaultMutableTreeNode nodeName) {

		DefaultMutableTreeNode node;
		Token token = queue.peek();

		if (token.getValue().equals(Terminal.LEFT_CURLY_B)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			node = new DefaultMutableTreeNode("StatementSTM");
			nodeName.add(node);
			StatementSTM stm = statementSTM(node);
			if (stm == null)
				return null;

			token = queue.peek();
			if (!token.getValue().equals(Terminal.RIGHT_CURLY_B)) {
				System.out.println("expected '}' in statemnet class");
				return null;
			}

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			return new Statement1(stm);

		} else if (token.getValue().equals(Terminal.IF)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			token = queue.peek();

			if (!token.getValue().equals(Terminal.LEFT_ROUND_B)) {
				System.out.println("expected '(' in statemnet class");
				return null;
			}

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Excepression");
			nodeName.add(node);

			Expression exp = expression(node);
			if (exp == null)
				return null;

			token = queue.peek();
			if (!token.getValue().equals(Terminal.RIGHT_ROUND_B)) {
				System.out.println("expected ')' in statemnet class");
				return null;
			}

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Statement");
			nodeName.add(node);
			Statment stm = statment(node);
			if (stm == null)
				return null;

			node = new DefaultMutableTreeNode("Else");
			nodeName.add(node);

			ElseInterface el = ELSE(node);
			if (el == null)
				return null;

			return new Statement2(exp, stm, el);
		} else if (token.getValue().equals(Terminal.WHILE)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			token = queue.peek();
			if (!token.getValue().equals(Terminal.LEFT_ROUND_B)) {
				System.out.println("expected '( in statemnet class");
				return null;
			}
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			node = new DefaultMutableTreeNode("Excepration");
			nodeName.add(node);

			Expression exp = expression(node);
			if (exp == null)
				return null;

			token = queue.peek();
			if (!token.getValue().equals(Terminal.RIGHT_ROUND_B)) {
				System.out.println("expected ')' in statemnet class");
				return null;
			}
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			node = new DefaultMutableTreeNode("Statement");
			nodeName.add(node);

			Statment stm = statment(node);
			if (stm == null)
				return null;

			return new Statement3(exp, stm);

		} else if (token.getValue().equals(Terminal.SYSTEM_OUT_PRINTLN)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();
			token = queue.peek();
			if (!token.getValue().equals(Terminal.LEFT_ROUND_B)) {
				System.out.println("expected '(' in statemnet class");
				return null;
			}
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			node = new DefaultMutableTreeNode("Excepration");
			nodeName.add(node);

			Expression exp = expression(node);
			if (exp == null) {
				return null;
			}

			token = queue.peek();
			if (!token.getValue().equals(Terminal.RIGHT_ROUND_B)) {
				System.out.println("expected ')' in statemnet class");
				return null;
			}
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			token = queue.peek();
			if (!token.getValue().equals(Terminal.SEMICOLON)) {
				System.out.println("expected ';' in statemnet class");
				return null;
			}
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			return new Statement4(exp);

		} else if (token.getType().equals(Terminal.Identifier)) {
			Token t = token;
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			node = new DefaultMutableTreeNode("IdentifeirAssign");
			nodeName.add(node);

			IdentifierAssign IDAssign = IdentifeirAssign(node);
			if (IDAssign == null)
				return null;

			return new Statement5(new Identifier(t.getValue()), IDAssign);
		}
		return null;
	}

	// <StatementSTM> -> <Statement> <StatementSTM> | $
	private StatementSTM statementSTM(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;
		Token token = queue.peek();
		if (!token.getValue().equals(Terminal.LEFT_CURLY_B) && !token.getValue().equals(Terminal.IF)
				&& !token.getValue().equals(Terminal.WHILE) && !token.getValue().equals(Terminal.SYSTEM_OUT_PRINTLN)
				&& !token.getType().equals(Terminal.Identifier)) {
			return new StatementSTM2();
		}

		node = new DefaultMutableTreeNode("Statement");
		nodeName.add(node);
		Statment stm = statment(node);
		if (stm == null)
			return null;

		node = new DefaultMutableTreeNode("StatementSTM");
		nodeName.add(node);

		return new StatementSTM1(stm, statementSTM(node));

	}

	// <IdentifierAssign> -> "=" <Expression> ";" | "[" <Expression> "]" "="
	// <Expression> ";"
	private IdentifierAssign IdentifeirAssign(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;

		Token token = queue.peek();
		if (token.getValue().equals(Terminal.EQUAL)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			node = new DefaultMutableTreeNode("Excepression");
			nodeName.add(node);

			Expression ex = expression(node);
			if (ex == null)
				return null;

			token = queue.peek();
			if (!token.getValue().equals(Terminal.SEMICOLON)) {
				System.out.println("expected ';' in Identifier Assign class");
				return null;
			}
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			return new IdentifierAssign1(ex);

		} else if (token.getValue().equals(Terminal.LEFT_SQUARE_B)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			node = new DefaultMutableTreeNode("Expression");
			nodeName.add(node);

			Expression ex = expression(node);
			if (ex == null)
				return null;

			token = queue.peek();
			if (!token.getValue().equals(Terminal.RIGHT_SQUARE_B)) {
				System.out.println("expected ']' in Identifier Assign class");
				return null;
			}
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			token = queue.peek();
			if (!token.getValue().equals(Terminal.EQUAL)) {
				System.out.println("expected '=' in Identifier Assign class");
				return null;
			}
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			node = new DefaultMutableTreeNode("Expression");
			nodeName.add(node);
			Expression ex2 = expression(node);
			if (ex == null)
				return null;

			token = queue.peek();
			if (!token.getValue().equals(Terminal.SEMICOLON)) {
				System.out.println("expected ';' in Identifier Assign class");
				return null;
			}
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();
			return new IdentifierAssign2(ex, ex2);
		}

		return null;
	}

	// <Else> -> "else" <Statement> | $
	private ElseInterface ELSE(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;
		Token token = queue.peek();
		if (token.getValue().equals(Terminal.ELSE)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();
			node = new DefaultMutableTreeNode("Statement");
			nodeName.add(node);
			Statment stm = statment(node);
			if (stm == null)
				return null;
			return new Else(stm);
		}

		return new notElse();
	}

	// <VarDeclarationSTM> -> <VarDeclaration> <VarDeclarationSTM> | $
	private VarDeclarationSTM varDeclarationSTM(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;
		Token token = queue.peek();

		if (!token.getValue().equals(Terminal.INT) && !token.getValue().equals(Terminal.FLOAT)
				&& !token.getValue().equals(Terminal.BOOLEAN) && !token.getValue().equals(Terminal.A_CHAR)
				&& !token.getValue().equals(Terminal.STRING)) {
			return new VarDeclarationSTM2();
		}
		node = new DefaultMutableTreeNode("VarDeclarationSTM");
		nodeName.add(node);
		VarDeclaration vl = varDeclaration(node);
		if (vl == null)
			return null;

		node = new DefaultMutableTreeNode("VarDeclarationSTM");
		nodeName.add(node);
		return new VarDeclarationSTM1(vl, varDeclarationSTM(node));

	}

	// <MethodDeclarationSTM> -> <MethodDeclaration> <MethodDeclarationSTM> | $
	private MethodDeclarationSTM methodDeclarationSTM(DefaultMutableTreeNode nodeName) {

		DefaultMutableTreeNode node;
		node = new DefaultMutableTreeNode("Visability");
		nodeName.add(node);

		Visiblity vis = visability(node);
		if (vis == null)
			return new MethodDeclarationSTM2();

		node = new DefaultMutableTreeNode("MethodDeclaration");
		nodeName.add(node);

		MethodDeclaration m1 = methodDeclaration(vis, node);
		if (m1 == null)
			return null;

		node = new DefaultMutableTreeNode("MethodDeclrationSTM");
		nodeName.add(node);
		return new MethodDeclarationSTM1(m1, methodDeclarationSTM(node));
	}

	// <Visiblity> -> "public" | "private"
	private Visiblity visability(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;
		Token token = queue.peek();
		if (token.getValue().equals(Terminal.PUBLIC)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();
			return new Public();
		} else if (token.getValue().equals(Terminal.PRIVATE)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();
			return new Private();
		}

		return null;
	}

	// <Type> -> "boolean" <Array>| "int" <Array> | "float" <Array> | "String"
	// <Array> | "char" <Array>
	private Type type(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;
		Token token = queue.peek();
		if (token.getValue().equals(Terminal.INT)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			node = new DefaultMutableTreeNode("Array");
			nodeName.add(node);
			Array ar = array(node);
			if (ar == null)
				return null;
			return new IntType(ar);
		}
		if (token.getValue().equals(Terminal.FLOAT)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			node = new DefaultMutableTreeNode("Array");
			nodeName.add(node);
			Array ar = array(node);
			if (ar == null)
				return null;
			return new FloatType(ar);
		}
		if (token.getValue().equals(Terminal.STRING)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			node = new DefaultMutableTreeNode("Array");
			nodeName.add(node);
			Array ar = array(node);
			if (ar == null)
				return null;
			return new StringType(ar);
		}
		if (token.getValue().equals(Terminal.BOOLEAN)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();

			node = new DefaultMutableTreeNode("Array");
			nodeName.add(node);
			Array ar = array(node);
			if (ar == null)
				return null;
			return new BooleanType(ar);
		}
		if (token.getValue().equals(Terminal.A_CHAR)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);
			queue.poll();
			node = new DefaultMutableTreeNode("Array");
			nodeName.add(node);
			Array ar = array(node);
			if (ar == null)
				return null;
			return new CharType(ar);
		}
		return null;
	}

	// <Array> -> "[" "]" | $
	private Array array(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;
		Token token = queue.peek();
		if (token.getValue().equals(Terminal.LEFT_SQUARE_B)) {

			node = new DefaultMutableTreeNode("Array");
			nodeName.add(node);
			queue.poll();
			token = queue.peek();
			if (token.getValue().equals(Terminal.RIGHT_SQUARE_B)) {

				node = new DefaultMutableTreeNode("Array");
				nodeName.add(node);
				queue.poll();
				return new Array2();
			}
			System.out.println("expected ']' in array class");
			return null;
		}

		return new Array1();
	}

	// <MethodDeclaration> -> <Visiblity> <Type> <Identifier> "("
	// <ParamerterSTM> ")" "{" <VarDeclarationSTM> <StatementSTM> "return"
	// <Expression> ";" "}"
	private MethodDeclaration methodDeclaration(Visiblity vis, DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;
		// Visiblity vis = visability();
		// if (vis == null)
		// return null;

		node = new DefaultMutableTreeNode("Type");
		nodeName.add(node);

		Type ty = type(node);
		if (ty == null)
			return null;

		Token token = queue.peek();
		if (!token.getType().equals(Terminal.Identifier)) {
			System.out.println("expected 'ID' in method declaration class");
			return null;
		}
		Identifier id = new Identifier(token.getValue());

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		token = queue.peek();
		if (!token.getValue().equals(Terminal.LEFT_ROUND_B)) {
			System.out.println("expected '(' in method declaration class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);
		queue.poll();

		node = new DefaultMutableTreeNode("ParamterSTM");
		nodeName.add(node);

		ParamerterSTM pr = paramerterSTM(node);
		if (pr == null)
			return null;

		token = queue.peek();
		if (!token.getValue().equals(Terminal.RIGHT_ROUND_B)) {
			System.out.println("expected ')' in method declaration class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);
		queue.poll();

		token = queue.peek();
		if (!token.getValue().equals(Terminal.LEFT_CURLY_B)) {
			System.out.println("expected '{' in method declaration class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);
		queue.poll();

		node = new DefaultMutableTreeNode("varDeclarationStm");
		nodeName.add(node);

		VarDeclarationSTM varDe = varDeclarationSTM(node);
		if (varDe == null)
			return null;

		node = new DefaultMutableTreeNode("StatementSTM");
		nodeName.add(node);

		StatementSTM stm = statementSTM(node);
		if (stm == null)
			return null;

		token = queue.peek();
		if (!token.getValue().equals(Terminal.RETURN)) {
			System.out.println("expected 'return' in method declaration class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);
		queue.poll();

		node = new DefaultMutableTreeNode("Expression");
		nodeName.add(node);

		Expression ex = expression(node);
		if (ex == null)
			return null;

		token = queue.peek();

		if (!token.getValue().equals(Terminal.SEMICOLON)) {
			System.out.println("expected ';' in method declaration class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();
		token = queue.peek();
		if (!token.getValue().equals(Terminal.RIGHT_CURLY_B)) {
			System.out.println("expected '}' in method declaration class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		return new MethodDeclaration(vis, ty, id, pr, varDe, stm, ex);
	}

	// <VarDeclaration> -> <Type> <Identifier> ";"
	private VarDeclaration varDeclaration(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;
		node = new DefaultMutableTreeNode("Type");
		nodeName.add(node);
		Type t = type(node);
		if (t == null)
			return null;
		Token token = queue.peek();
		if (!token.getType().equals(Terminal.Identifier)) {
			System.out.println("expected 'ID' in var decleration class");
			return null;
		}
		Identifier id = new Identifier(token.getValue());

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();
		token = queue.peek();
		if (!token.getValue().equals(Terminal.SEMICOLON)) {
			System.out.println("expected ';' in var declaration class");
			return null;
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);
		queue.poll();

		return new VarDeclaration(t, id);
	}

	// <ParamerterSTM> -> <Type> <Identifier> <Paramerter> | $
	private ParamerterSTM paramerterSTM(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;

		node = new DefaultMutableTreeNode("Type");
		nodeName.add(node);

		Type t = type(node);
		if (t == null)
			return new ParamerterSTM2();
		Token token = queue.peek();
		if (!token.getType().equals(Terminal.Identifier)) {
			System.out.println("expected 'ID' in parameter STM class");
			return null;
		}
		Identifier id = new Identifier(token.getValue());

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		node = new DefaultMutableTreeNode("Paramter");
		nodeName.add(node);

		Paramerter p = paramerter(node);
		if (p == null)
			return null;
		return new ParamerterSTM1(t, id, p);
	}

	// <Paramerter> -> "," <Type> <Identifier> <Paramerter> | $
	private Paramerter paramerter(DefaultMutableTreeNode nodeName) {

		DefaultMutableTreeNode node;

		Token token = queue.peek();
		if (!token.getValue().equals(Terminal.COMMA)) {
			return new Paramerter2();
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		node = new DefaultMutableTreeNode("Type");
		nodeName.add(node);

		Type t = type(node);
		if (t == null)
			return null;

		token = queue.peek();
		if (!token.getType().equals(Terminal.Identifier)) {
			System.out.println("expected 'ID' in parameter class");
			return null;
		}
		Identifier id = new Identifier(token.getValue());

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		node = new DefaultMutableTreeNode("Parameter");
		nodeName.add(node);

		Paramerter p = paramerter(node);
		if (p == null)
			return null;
		return new Paramerter1(t, id, p);
	}

	/*
	 * <Expression> -> "!" <Expression> <ExpressionRec> | "(" <Expression>
	 * ")"<ExpressionRec> | <INTEGER_LITERAL> <ExpressionRec> |
	 * "true"<ExpressionRec> | "false" <ExpressionRec> | <Identifier>
	 * <ExpressionRec> | "this" <ExpressionRec> | "new" <Constructor>
	 * <ExpressionRec>
	 */

	private Expression expression(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;

		Token token = queue.peek();
		if (token.getValue().equals(Terminal.NOT)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Expression");
			nodeName.add(node);

			Expression expr = expression(node);
			if (expr == null)
				return null;

			node = new DefaultMutableTreeNode("Expression Rec");
			nodeName.add(node);

			ExpressionRec exprR = expressionRec(node);
			if (exprR == null)
				return null;

			return new Expression1(expr, exprR);
		} else if (token.getValue().equals(Terminal.LEFT_ROUND_B)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Expression");
			nodeName.add(node);

			Expression expr = expression(node);
			if (expr == null)
				return null;

			token = queue.peek();
			if (!token.getValue().equals(Terminal.RIGHT_ROUND_B)) {
				System.out.println("expected ')' in expression class");
				return null;
			}
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Expression Rec");
			nodeName.add(node);

			ExpressionRec exprR = expressionRec(node);
			if (exprR == null)
				return null;

			return new Expression2(expr, exprR);
		} else if (token.getType().equals(Terminal.INTEGRAL_LITERAL)) {
			Token t = token;

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Expression Rec");
			nodeName.add(node);

			ExpressionRec exRec = expressionRec(node);
			if (exRec == null)
				return null;
			return new Expression3(exRec, new INTEGRAL_LITERAL(t.getValue()));
		} else if (token.getValue().equals(Terminal.TRUE)) {
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Expression Rec");
			nodeName.add(node);

			ExpressionRec exRec = expressionRec(node);
			if (exRec == null)
				return null;

			return new Expression4(exRec);
		} else if (token.getValue().equals(Terminal.FALSE)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Expression Rec");
			nodeName.add(node);

			ExpressionRec exRec = expressionRec(node);
			if (exRec == null)
				return null;

			return new Expression5(exRec);
		} else if (token.getType().equals(Terminal.Identifier)) {
			Token t = token;

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("expression Rec");
			nodeName.add(node);

			ExpressionRec exRec = expressionRec(node);
			if (exRec == null)
				return null;

			return new Expression6(exRec, new Identifier(t.getValue()));

		} else if (token.getValue().equals(Terminal.THIS)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Expression Rec");
			nodeName.add(node);

			ExpressionRec exRec = expressionRec(node);
			if (exRec == null)
				return null;

			return new Expression7(exRec);
		} else if (token.getValue().equals(Terminal.NEW)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Constractor");
			nodeName.add(node);

			Constructor_ con = constructor(node);
			if (con == null)
				return null;

			node = new DefaultMutableTreeNode("Expression Rec");
			nodeName.add(node);

			ExpressionRec exRec = expressionRec(node);
			if (exRec == null)
				return null;

			return new Expression8(exRec, con);
		}

		return null;
	}

	/*
	 * <ExpressionRec> -> <Operator> <Expression> <ExpressionRec>
	 * "["<Expression> "]" <ExpressionRec> "." <Expression1Fn> | $
	 */
	private ExpressionRec expressionRec(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;

		Token token = queue.peek();

		node = new DefaultMutableTreeNode("Operator");
		nodeName.add(node);

		Operator op = operator(node);
		if (op != null) {

			node = new DefaultMutableTreeNode("Expression");
			nodeName.add(node);

			Expression expr = expression(node);
			if (expr == null)
				return null;

			node = new DefaultMutableTreeNode("Expression Rec");
			nodeName.add(node);

			ExpressionRec exprR = expressionRec(node);
			if (exprR == null)
				return null;

			return new ExpressionRec1(op, expr, exprR);
		} else if (token.getValue().equals(Terminal.LEFT_SQUARE_B)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Expression");
			nodeName.add(node);

			Expression expr = expression(node);

			if (expr == null)
				return null;

			token = queue.peek();

			if (!token.getValue().equals(Terminal.RIGHT_SQUARE_B)) {
				System.out.println("expected ']' in expression rec class");
				return null;
			}
			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Expression Rec");
			nodeName.add(node);

			ExpressionRec exprR = expressionRec(node);
			if (exprR == null)
				return null;

			return new ExpressionRec2(expr, exprR);
		} else if (token.getValue().equals(Terminal.DOT)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Expression 1 Fun");
			nodeName.add(node);

			Expression1Fn expr1 = expression1Fn(node);
			if (expr1 == null)
				return null;
			return new ExpressionRec3(expr1);
		}

		return new ExpressionRec4();
	}

	private Operator operator(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;

		Token token = queue.peek();
		if (token.getValue().equals(Terminal.AND)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();
			return new Operator1();
		} else if (token.getValue().equals(Terminal.GREATERTHAN)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();
			return new Operator2();
		} else if (token.getValue().equals(Terminal.PLUS)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();
			return new Operator3();
		} else if (token.getValue().equals(Terminal.MINUS)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();
			return new Operator4();
		} else if (token.getValue().equals(Terminal.MULTIPLY)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();
			return new Operator5();
		} else if (token.getValue().equals(Terminal.LESSTHAN)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();
			return new Operator6();
		}
		return null;
	}

	/*
	 * <Constructor> -> "int" "[" <Expression> "]" | <Identifier> "(" ")"
	 */
	private Constructor_ constructor(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;

		Token token = queue.peek();
		if (token.getValue().equals(Terminal.INT)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			token = queue.poll();

			node = new DefaultMutableTreeNode(token.getValue()); /// bt3t elli
																	/// fo2eha
			nodeName.add(node);

			if (!token.getValue().equals(Terminal.LEFT_SQUARE_B)) {
				System.out.println("expected '[' in constructor class");
				return null;
			}

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("Expression");
			nodeName.add(node);

			Expression expr = expression(node);

			if (expr == null)
				return null;

			token = queue.peek();

			if (!token.getValue().equals(Terminal.RIGHT_SQUARE_B)) {
				System.out.println("expected ']' in constructor class");
				return null;
			}

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			return new Constructor_1(expr);
		} else if (token.getType().equals(Terminal.Identifier)) {
			Token t = token;

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			token = queue.peek();
			if (!token.getValue().equals(Terminal.LEFT_ROUND_B)) {
				System.out.println("expected '(' in constructor class");
				return null;
			}

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();
			token = queue.peek();
			if (!token.getValue().equals(Terminal.RIGHT_ROUND_B)) {
				System.out.println("expected ')' in constructor class");
				return null;
			}

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			return new Constructor_2(new Identifier(t.getValue()));
		}
		return null;
	}

	/*
	 * <Expression1Fn> -> "length" <Expression1> | <Identifier> "("
	 * <ExpressionSTM2> ")" <Expression1>
	 */
	private Expression1Fn expression1Fn(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;

		Token token = queue.peek();
		if (token.getValue().equals(Terminal.LENGTH)) {

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("expressionRec");
			nodeName.add(node);

			ExpressionRec exR = expressionRec(node);

			if (exR == null)
				return null;

			return new Expression1Fn1(exR);
		} else if (token.getType().equals(Terminal.Identifier)) {
			Token t = token;

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();
			token = queue.peek();
			if (!token.getValue().equals(Terminal.LEFT_ROUND_B)) {
				System.out.println("expected '(' in expression fun class");
				return null;
			}

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("expression STM_");
			nodeName.add(node);

			ExpressionSTM_ expr = expressionSTM_(node);
			if (expr == null)
				return null;

			token = queue.peek();
			if (!token.getValue().equals(Terminal.RIGHT_ROUND_B)) {
				System.out.println("expected ')' in expression fun class");
				return null;
			}

			node = new DefaultMutableTreeNode(token.getValue());
			nodeName.add(node);

			queue.poll();

			node = new DefaultMutableTreeNode("expression Rec");
			nodeName.add(node);

			ExpressionRec exR = expressionRec(node);
			if (exR == null)
				return null;
			// System.out.println("error in expression fun class");
			return new Expression1Fn2(new Identifier(t.getValue()), expr, exR);
		}

		return null;
	}

	// <ExpressionSTM> -> "," <Expression> <ExpressionSTM> | $
	private ExpressionSTM expressionSTM(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;

		Token token = queue.peek();
		if (!token.getValue().equals(Terminal.COMMA)) {
			return new ExpressionSTM2();
		}

		node = new DefaultMutableTreeNode(token.getValue());
		nodeName.add(node);

		queue.poll();

		node = new DefaultMutableTreeNode("Expression");
		nodeName.add(node);

		Expression exp = expression(node);
		if (exp == null) {
			return null;
		}

		node = new DefaultMutableTreeNode("Expression STM");
		nodeName.add(node);

		ExpressionSTM expSTM = expressionSTM(node);
		if (expSTM == null) {
			return null;
		}

		return new ExpressionSTM1(expSTM, exp);
	}

	// <ExpressionSTM_> -> <Expression> <ExpressionSTM> | $
	private ExpressionSTM_ expressionSTM_(DefaultMutableTreeNode nodeName) {
		DefaultMutableTreeNode node;

		Token token = queue.peek();
		if (token.getValue().equals(Terminal.NOT) || token.getValue().equals(Terminal.LEFT_ROUND_B)
				|| token.getType().equals(Terminal.INTEGRAL_LITERAL) || token.getValue().equals(Terminal.TRUE)
				|| token.getValue().equals(Terminal.FALSE) || token.getValue().equals(Terminal.THIS)
				|| token.getValue().equals(Terminal.NEW) || token.getType().equals(Terminal.Identifier)) {

			node = new DefaultMutableTreeNode("Expression");
			nodeName.add(node);

			Expression exp = expression(node);
			if (exp == null)
				return null;

			node = new DefaultMutableTreeNode("Expression STM");
			nodeName.add(node);

			ExpressionSTM expSTM = expressionSTM(node);
			if (expSTM == null) {
				return null;
			}

			return new ExpressionSTM_1(expSTM, exp);
		}

		return new ExpressionSTM_2();
	}

}
