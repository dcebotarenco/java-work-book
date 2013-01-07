package ToolBarTest;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Clasa adaugatoare pentru lucru cu GridBagLayout
 * @author Dan
 *
 */
public class GBC extends GridBagConstraints
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creaza obiect GBC,care gaseste pozitiile gridx si gridy
	 * restu se put default
	 * @param gridx pozitia gridx
	 * @param gridy pozitia gridy
	 */
	public GBC(int gridx,int gridy)
	{
		this.gridx=gridx;
		this.gridy=gridy;
	}
	/**
	 * Creaza obiectul GBC, gaseste gridx ,gridy,gridwidth si gridheight.
	 * restul se pun default
	 */
	public GBC(int gridx,int gridy,int gridwidth,int gridheight)
	{
		this.gridx=gridx;
		this.gridy=gridy;
		this.gridwidth=gridwidth;
		this.gridheight=gridheight;
	}
	/**
	 * Seteaza parametrul anchor
	 * @param anchor valoarea parametrului
	 * return Obiect this, care se foloseste mai departe
	 */
	public GBC setAnchor(int anchor)
	{
		this.anchor = anchor;
		return this;
	}
	
	/**
	 * Seteaza parametrul fill
	 * @param fill valoarea parametrului
	 * return Obiect this, care se foloseste mai departe
	 */
	public GBC setFill(int fill)
	{
		this.fill = fill;
		return this;
	}
	/**
	 * Seteaza greutatea celulelor
	 * @param weigthx greutatea miscarii x
	 * @param e greutatea miscarii y
	 * @return Biect this, care se va folosi
	 */
	public GBC setWeight(double d,double e)
	{
		this.weightx=d;
		this.weighty=e;
		return this;
	}
	/**
	 * Seteaza marimile locurilor intre celule
	 * @param distance marimile pe toate directiile
	 * @return Obiect this, care se va folosi
	 */
	public GBC setInsets(int destance)
	{
		this.insets = new Insets(destance, destance, destance, destance);
		return this;
	}
	/**
	 * seteaza marimile intre celule aparte
	 * @param top marimea de sus
	 * @param left marimea de stinga
	 * @param bottom marimea de jos
	 * @param roght marimea de jos
	 * @return Obiect this care se va folosi
	 */
	public GBC setInsets(int top,int left,int bottom, int right)
	{
		this.insets = new Insets(top,left,bottom,right);
		return this;
	}
	/**
	 * Seteaza volumul din nauntru
	 * @param ipadx volumul x
	 * @param ipady volumul y
	 * @return Obiect this care se va folosi
	 */
	public GBC setIpad(int ipadx,int ipady)
	{
		this.ipadx =ipadx;
		this.ipady =ipady;
		return this;
	}
}
