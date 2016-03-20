// // Copyright 2016 theaigames.com (developers@theaigames.com)
// Modified by MK, aka Kobrasadetin
//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at
//        http://www.apache.org/licenses/LICENSE-2.0
//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//  
//    For the full copyright and license information, please view the LICENSE
//    file that was distributed with this source code.
package move;

/**
 * Move class
 *
 * Stores a move.
 *
 * @author Jim van Eeden <jim@starapple.nl>, Joost de Meij <joost@starapple.nl>
 */
public class Move {

    int mX, mY;

    public Move() {
    }

    public Move(int x, int y) {
        mX = x;
        mY = y;
    }

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }

    @Override
    public int hashCode() {
        int hash = 100 * this.mX + this.mY;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Move other = (Move) obj;
        if (this.mX != other.mX) {
            return false;
        }
        if (this.mY != other.mY) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Move{" + "X= " + mX + ", Y= " + mY + '}';
    }

}